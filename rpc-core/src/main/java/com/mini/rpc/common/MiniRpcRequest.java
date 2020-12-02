package com.mini.rpc.common;

import lombok.Data;

@Data
public class MiniRpcRequest {
    private String requestId;
    private String serviceVersion;
    private String className;
    private String methodName;
    private Object[] params;
    private Class<?>[] parameterTypes;
}
