package com.devil.basic.design.state;

/**
 * @author Devil
 * @date Created in 2021/7/27 22:11
 */
public class Lift {
    
    //定义出电梯的所有状态
    private LiftState openningState;
    
    private LiftState closingState;
    
    private LiftState runningState;
    
    private LiftState stoppingState;
    
    public Lift() {
        openningState = new OpenState(this);
        closingState = new CloseState(this);
        runningState = new RunState(this);
        stoppingState = new StopState(this);
    }
    
    //定义电梯状态
    LiftState state;
    
    public void open() {
        state.open();
    }
    
    public void close() {
        state.close();
    }
    
    public void run() {
        state.run();
    }
    
    public void stop() {
        state.stop();
    }
    
    public void setState(LiftState state) {
        this.state = state;
    }
    
    public LiftState getOpenningState() {
        return openningState;
    }
    
    public LiftState getCloseingState() {
        return closingState;
    }
    
    public LiftState getRunningState() {
        return runningState;
    }
    
    public LiftState getStoppingState() {
        return stoppingState;
    }
    
    
}
