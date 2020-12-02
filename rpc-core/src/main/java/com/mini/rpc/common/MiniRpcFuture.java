package com.mini.rpc.common;

import io.netty.util.concurrent.Promise;
import lombok.Data;

@Data
public class MiniRpcFuture<T> {
    private Promise<T> promise;
    private long timeout;

    public MiniRpcFuture(Promise<T> promise, long timeout) {
        this.promise = promise;
        this.timeout = timeout;
    }
}
