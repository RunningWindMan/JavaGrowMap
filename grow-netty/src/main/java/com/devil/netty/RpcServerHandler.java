package com.devil.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Calendar;
import java.util.UUID;

/**
 * rpc服务端处理
 *
 * @author Devil
 * @date Created in 2021/7/26 17:15
 */
public class RpcServerHandler extends ChannelInboundHandlerAdapter {

    // 接受client发送的消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequest request = (RpcRequest) msg;
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.MILLISECOND);
        System.out.println(i + " 接收到客户端信息:" + request.toString());
        // 返回的数据结构
        RpcResponse response = new RpcResponse();
        response.setId(UUID.randomUUID().toString());
        response.setData("server响应结果");
        ctx.writeAndFlush(response);
    }

    // 通知处理器最后的channelRead()是当前批处理中的最后一条消息时调用
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务端接收数据完毕..");
        ctx.flush();
    }

    // 读操作时捕获到异常时调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

    // 客户端去和服务端连接成功时触发
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush("hello client");
    }

}
