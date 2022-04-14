package com.devil.basic.design.factory.func;

import com.devil.basic.design.factory.simple.Animal;
import com.devil.basic.design.factory.simple.Cat;

/**
 * @author Devil
 * @date Created in 2021/7/22 14:18
 */
public class CatFactory implements IAnimalFactory {
    
    @Override
    public Animal create() {
        return new Cat();
    }
}
