package com.devil.basic.design.factory.simple;

/**
 * 简单工厂
 *
 * @author Devil
 * @date Created in 2021/7/22 14:03
 */
public class SimpleAnimalFactory {

    public static Animal create(String animalType) {
        if (animalType == null || "".equals(animalType)) {
            return new Dog();
        }

        switch (animalType) {
            case "cat":
                return new Cat();
            case "sheep":
                return new Sheep();
            default:
                return new Dog();
        }

    }

}
