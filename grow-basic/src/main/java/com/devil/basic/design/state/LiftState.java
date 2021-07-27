package com.devil.basic.design.state;

/**
 * 定义电梯的状态：打开、关闭、运行、停止
 *
 * @author Devil
 * @date Created in 2021/7/27 22:09
 */
public interface LiftState {

    void open();

    void close();

    void run();

    void stop();

}
