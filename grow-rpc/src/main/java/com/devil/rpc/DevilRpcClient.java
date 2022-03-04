package com.devil.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author Devil
 * @date Created in 2022/3/4 14:46
 */
public class DevilRpcClient<T> {

    public <T> T proxyClient(Class<T> clazz, int port) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, (proxy, method, args) -> {
            try (Socket socket = new Socket("localhost", port)) {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                // 传方法名
                oos.writeUTF(method.getName());
                // 传参数类型
                oos.writeObject(method.getParameterTypes());
                // 传参数值
                oos.writeObject(args);
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                // 读取结果
                Object result = input.readObject();
                return result;
            }
        });
    }

    public static void main(String[] args) {
        DevilRpcClient<IDevilRpcService> client = new DevilRpcClient<>();
        IDevilRpcService rpcService = client.proxyClient(IDevilRpcService.class, 22222);
        System.out.println(rpcService.hello());
    }

}
