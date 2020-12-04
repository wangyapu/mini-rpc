package com.mini.rpc.provider.registry;

import com.mini.rpc.common.ServiceMeta;

public class EurekaRegistryService implements RegistryService {

    public EurekaRegistryService(String registryAddr) {
        // TODO
    }

    @Override
    public void register(ServiceMeta serviceMeta) {

    }

    @Override
    public void unRegister(ServiceMeta serviceMeta) {

    }

    @Override
    public ServiceMeta discovery(String serviceName, int invokerHashCode) {
        return null;
    }

    @Override
    public void destroy() {

    }
}
