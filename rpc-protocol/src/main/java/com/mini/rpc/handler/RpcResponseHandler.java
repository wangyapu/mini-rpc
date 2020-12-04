package com.mini.rpc.handler;


import com.mini.rpc.common.MiniRpcFuture;
import com.mini.rpc.common.MiniRpcRequestHolder;
import com.mini.rpc.common.MiniRpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RpcResponseHandler extends SimpleChannelInboundHandler<MiniRpcResponse> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MiniRpcResponse msg) throws Exception {
        MiniRpcFuture<MiniRpcResponse> future = MiniRpcRequestHolder.REQUEST_MAP.remove(msg.getRequestId());
        future.getPromise().setSuccess(msg);
    }
}

