package com.devil.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Calendar;

/**
 * rpc客户端处理器
 *
 * @author Devil
 * @date Created in 2021/7/26 16:40
 */
public class RpcClientHandler extends SimpleChannelInboundHandler<RpcResponse> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcResponse rpcResponse) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.MILLISECOND);
        System.out.println(i + " 接受到server响应数据: " + rpcResponse.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
