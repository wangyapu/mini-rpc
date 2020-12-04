package com.mini.rpc.registry;

import com.mini.rpc.common.ServiceMeta;
import com.mini.rpc.provider.registry.RegistryFactory;
import com.mini.rpc.provider.registry.RegistryService;
import com.mini.rpc.provider.registry.RegistryType;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class RegistryTest {

    private RegistryService registryService;

    @Before
    public void init() throws Exception {
        registryService = RegistryFactory.getInstance("127.0.0.1:2181", RegistryType.ZOOKEEPER);
    }

    @After
    public void close() throws Exception {
        registryService.destroy();
    }

    @Test
    public void testAll() throws Exception {
        ServiceMeta serviceMeta1 = new ServiceMeta();
        serviceMeta1.setServiceAddr("127.0.0.1");
        serviceMeta1.setServicePort(8080);
        serviceMeta1.setServiceName("test1");
        serviceMeta1.setServiceVersion("1.0.0");

        ServiceMeta serviceMeta2 = new ServiceMeta();
        serviceMeta2.setServiceAddr("127.0.0.2");
        serviceMeta2.setServicePort(8080);
        serviceMeta2.setServiceName("test2");
        serviceMeta2.setServiceVersion("1.0.0");

        ServiceMeta serviceMeta3 = new ServiceMeta();
        serviceMeta3.setServiceAddr("127.0.0.3");
        serviceMeta3.setServicePort(8080);
        serviceMeta3.setServiceName("test3");
        serviceMeta3.setServiceVersion("1.0.0");

        registryService.register(serviceMeta1);
        registryService.register(serviceMeta2);
        registryService.register(serviceMeta3);

        ServiceMeta discovery1 = registryService.discovery("test1#1.0.0", "test1".hashCode());
        ServiceMeta discovery2 = registryService.discovery("test2#1.0.0", "test2".hashCode());
        ServiceMeta discovery3 = registryService.discovery("test3#1.0.0", "test3".hashCode());

        assert discovery1 != null;
        assert discovery2 != null;
        assert discovery3 != null;

        registryService.unRegister(discovery1);
        registryService.unRegister(discovery2);
        registryService.unRegister(discovery3);
    }

}
