package com.mini.rpc.provider.registry;

import com.mini.rpc.common.ServiceMeta;

import java.io.IOException;

public interface RegistryService {

    void register(ServiceMeta serviceMeta) throws Exception;

    void unRegister(ServiceMeta serviceMeta) throws Exception;

    ServiceMeta discovery(String serviceName) throws Exception;

    void destroy() throws IOException;
}
