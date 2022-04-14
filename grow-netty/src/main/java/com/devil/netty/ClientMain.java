package com.devil.netty;

import io.netty.channel.Channel;

import java.util.UUID;

/**
 * 客户端启动类
 *
 * @author Devil
 * @date Created in 2021/7/26 17:20
 */
public class ClientMain {
    
    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient("127.0.0.1", 8080);
        // 启动client服务
        client.start();
        
        Channel channel = client.getChannel();
        // 消息体
        RpcRequest request = new RpcRequest();
        request.setId(UUID.randomUUID().toString());
        request.setData("client.message");
        // channel对象可保存在map中，供其它地方发送消息
        channel.writeAndFlush(request);
    }
    
}
