package com.devil.basic.design.state;

/**
 * @author Devil
 * @date Created in 2021/7/27 22:12
 */
public class StopState implements LiftState {
    
    Lift lift;
    
    public StopState(Lift lift) {
        this.lift = lift;
    }
    
    @Override
    public void open() {
        //停止状态可以开门
        System.out.println("lift is openning");
        //更新电梯状态-->打开
        this.lift.setState(lift.getOpenningState());
    }
    
    @Override
    public void close() {
        //停止状态门本来就是关闭的
        System.out.println("lift is closing");
    }
    
    @Override
    public void run() {
        //停止状态可以继续运行
        System.out.println("lift is running");
        //更新电梯状态-->运行
        this.lift.setState(lift.getRunningState());
    }
    
    @Override
    public void stop() {
        //电梯当前状态-->关闭
        System.out.println("lift is stopping");
    }
}
