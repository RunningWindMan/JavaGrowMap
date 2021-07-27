package com.devil.basic.design.state;

/**
 * @author Devil
 * @date Created in 2021/7/27 22:11
 */
public class CloseState implements LiftState {
    Lift lift;

    public CloseState(Lift lift) {
        this.lift = lift;
    }

    @Override
    public void open() {
        //电梯关闭了再打开，是可以的
        System.out.println("lift is openning");
        //更新电梯当前状态-->打开
        this.lift.setState(lift.getOpenningState());
    }

    @Override
    public void close() {
        //电梯的当前状态-->关闭
        System.out.println("lift is closed");

    }

    @Override
    public void run() {
        //电梯关闭的状态下允许运行
        System.out.println("lift is running");
        //更新电梯当前状态-->运行
        this.lift.setState(lift.getRunningState());
    }

    @Override
    public void stop() {
        //电梯门关着，不按楼层，也可以
        System.out.println("lift is stopping");
        //更新电梯状态-->停止
        this.lift.setState(lift.getStoppingState());
    }
}
