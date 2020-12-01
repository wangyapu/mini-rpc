package com.mini.rpc.provider.registry;

import com.mini.rpc.common.ServiceMeta;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

public class ZookeeperRegistryService implements RegistryService {
    public static final int BASE_SLEEP_TIME_MS = 1000;
    public static final int MAX_RETRIES = 3;
    public static final String ZK_BASE_PATH = "/mini_rpc";

    private ServiceDiscovery<ServiceMeta> serviceDiscovery;

    public ZookeeperRegistryService(String registryAddr) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(registryAddr, new ExponentialBackoffRetry(BASE_SLEEP_TIME_MS, MAX_RETRIES));
        client.start();
        JsonInstanceSerializer<ServiceMeta> serializer = new JsonInstanceSerializer<>(ServiceMeta.class);
        this.serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceMeta.class)
                .client(client)
                .serializer(serializer)
                .basePath(ZK_BASE_PATH)
                .build();
        this.serviceDiscovery.start();
    }

    @Override
    public void register(ServiceMeta serviceMeta) {

    }

    @Override
    public void unRegister(ServiceMeta serviceMeta) {

    }

    @Override
    public ServiceMeta discovery(String serviceName) {
        return null;
    }

    @Override
    public void destroy() {

    }
}
