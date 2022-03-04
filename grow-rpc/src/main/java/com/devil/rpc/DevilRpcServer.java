package com.devil.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Devil
 * @date Created in 2022/3/4 14:45
 */
public class DevilRpcServer {

    public void publisherServer(Object service, int port) {
        try (ServerSocket ss = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = ss.accept()) {
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    // 读取方法名
                    String methodName = ois.readUTF();
                    // 参数类型
                    Class<?>[] parameterTypes = (Class<?>[]) ois.readObject();
                    // 参数
                    Object[] arguments = (Object[]) ois.readObject();
                    // 找到方法
                    Method method = service.getClass().getMethod(methodName, parameterTypes);
                    // 调用方法
                    Object result = method.invoke(service, arguments);
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(result);
                    oos.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DevilRpcServer server = new DevilRpcServer();
        IDevilRpcService rpcService = new DevilRpcServiceImpl();
        server.publisherServer(rpcService, 22222);
    }

}
