package com.devil.basic.design.state;

/**
 * @author Devil
 * @date Created in 2021/7/27 22:11
 */
public class RunState implements LiftState {
    
    Lift lift;
    
    public RunState(Lift lift) {
        this.lift = lift;
    }
    
    @Override
    public void open() {
        //电梯运行的时候不能开门
        System.out.println("lift is running can not open");
    }
    
    @Override
    public void close() {
        //电梯运行的时候本来门本来就是关闭的
        System.out.println("lift is closing");
    }
    
    @Override
    public void run() {
        //电梯当前状态-->运行
        System.out.println(" lift is running");
    }
    
    @Override
    public void stop() {
        //停止运行电梯
        System.out.println("lift is stopping");
        //更新电梯当前状态-->停止
        this.lift.setState(lift.getStoppingState());
    }
}
