package com.mini.rpc.consumer;

import com.mini.rpc.provider.registry.RegistryService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RpcInvokerProxy implements InvocationHandler {

    private final String serviceVersion;
    private final RegistryService registryService;

    public RpcInvokerProxy(String serviceVersion, RegistryService registryService) {
        this.serviceVersion = serviceVersion;
        this.registryService = registryService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return "hello, test proxy";
    }
}
