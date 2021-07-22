package com.devil.basic.design.factory.abst;

import com.devil.basic.design.factory.simple.Animal;

/**
 * 抽象工厂
 *
 * @author Devil
 * @date Created in 2021/7/22 14:29
 */
public interface AbstractZooFactory {

    Animal createAnimal();

    Ticket getTicket();

}
