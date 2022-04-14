package com.devil.basic.design.state;

/**
 * @author Devil
 * @date Created in 2021/7/27 22:12
 */
public class StateTest {
    
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(new OpenState(lift));
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
    
}
