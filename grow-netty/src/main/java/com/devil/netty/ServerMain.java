package com.devil.netty;

/**
 * 服务器启动类
 *
 * @author Devil
 * @date Created in 2021/7/26 17:19
 */
public class ServerMain {
    
    public static void main(String[] args) throws Exception {
        // 启动server服务
        new NettyServer(8080).run();
    }
    
}
