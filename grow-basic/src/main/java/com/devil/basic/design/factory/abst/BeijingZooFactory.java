package com.devil.basic.design.factory.abst;

import com.devil.basic.design.factory.simple.Animal;
import com.devil.basic.design.factory.simple.Sheep;

/**
 * @author Devil
 * @date Created in 2021/7/22 14:34
 */
public class BeijingZooFactory implements AbstractZooFactory {
    
    @Override
    public Animal createAnimal() {
        return new Sheep();
    }
    
    @Override
    public Ticket getTicket() {
        return new VipTicket();
    }
}
