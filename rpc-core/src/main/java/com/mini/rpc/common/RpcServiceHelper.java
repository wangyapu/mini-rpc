package com.mini.rpc.common;

public class RpcServiceHelper {
    public static String buildServiceKey(ServiceMeta serviceMeta) {
        return String.join("#", serviceMeta.getServiceName(), serviceMeta.getServiceVersion());
    }
}
