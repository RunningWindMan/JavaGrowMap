package com.devil.basic.design.state;

/**
 * @author Devil
 * @date Created in 2021/7/27 22:10
 */
public class OpenState implements LiftState {

    //拥有一个电梯对象，用于更新电梯当前状态
    Lift lift;

    public OpenState(Lift lift) {
        //通过构造函数引入电梯的实例化对象
        this.lift = lift;
    }

    @Override
    public void open() {
        //电梯当前状态--> 打开
        System.out.println("lift is openning");
    }

    @Override
    public void close() {
        System.out.println("lift is closeing");
        //更改电梯当前状态-->关闭
        lift.setState(lift.getCloseingState());
    }

    @Override
    public void run() {
        //电梯处于打开状态，不能直接运行，需要先关闭
        System.out.println("lift is openning can not run should be colsed firstly");
    }

    @Override
    public void stop() {
        //电梯打开的状态是处于停止状态
        System.out.println("lift is in a state of stop");
    }

}
