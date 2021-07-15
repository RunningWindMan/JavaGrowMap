package com.devil.basic.proxy.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Devil
 * @date Created in 2021/7/15 16:05
 */
public class WorkerProxy implements InvocationHandler {

    private static final Logger log = LoggerFactory.getLogger(WorkerProxy.class);

    private Object worker;

    public WorkerProxy(Object worker) {
        this.worker = worker;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("proxy start ==== ++++");
        method.invoke(worker, args);
        log.info("proxy end ==== ++++");
        return null;
    }

    public static void main(String[] args) {
        SimpleWorker simpleWorker = new SimpleWorker();
        InvocationHandler invocationHandler = new WorkerProxy(simpleWorker);
        Worker worker = (Worker) Proxy.newProxyInstance(SimpleWorker.class.getClassLoader(), SimpleWorker.class.getInterfaces(), invocationHandler);
        worker.work();
    }
}
