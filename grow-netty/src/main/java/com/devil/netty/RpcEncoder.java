package com.devil.netty;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码
 *
 * @author Devil
 * @date Created in 2021/7/26 17:04
 */
public class RpcEncoder extends MessageToByteEncoder {
    
    private Class<?> target;
    
    public RpcEncoder(Class target) {
        this.target = target;
    }
    
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        if (target.isInstance(msg)) {
            byte[] data = JSON.toJSONBytes(msg);
            // 先将消息长度写入，也就是消息头
            out.writeInt(data.length);
            // 消息体中包含我们要发送的数据
            out.writeBytes(data);
        }
    }
}
