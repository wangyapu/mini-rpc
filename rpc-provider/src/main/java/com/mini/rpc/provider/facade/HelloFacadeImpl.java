package com.mini.rpc.provider.facade;

import com.mini.rpc.provider.annotation.RpcService;
import org.springframework.stereotype.Service;

@RpcService(serviceInterface = HelloFacade.class, serviceVersion = "1.0.0")
@Service
public class HelloFacadeImpl implements HelloFacade {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
