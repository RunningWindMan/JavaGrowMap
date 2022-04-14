package com.devil.basic.design.factory.func;

import com.devil.basic.design.factory.simple.Animal;
import com.devil.basic.design.factory.simple.Dog;

/**
 * @author Devil
 * @date Created in 2021/7/22 14:18
 */
public class DogFactory implements IAnimalFactory {
    
    @Override
    public Animal create() {
        return new Dog();
    }
}
