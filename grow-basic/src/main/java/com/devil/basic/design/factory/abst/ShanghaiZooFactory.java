package com.devil.basic.design.factory.abst;

import com.devil.basic.design.factory.simple.Animal;
import com.devil.basic.design.factory.simple.Dog;

/**
 * @author Devil
 * @date Created in 2021/7/22 14:35
 */
public class ShanghaiZooFactory implements AbstractZooFactory {
    
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
    
    @Override
    public Ticket getTicket() {
        return new CommonTicket();
    }
}
