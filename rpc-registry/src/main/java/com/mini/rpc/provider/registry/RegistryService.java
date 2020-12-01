package com.mini.rpc.provider.registry;

import com.mini.rpc.common.ServiceMeta;

public interface RegistryService {

    void register(ServiceMeta serviceMeta);

    void unRegister(ServiceMeta serviceMeta);

    ServiceMeta discovery(String serviceName);

    void destroy();
}
