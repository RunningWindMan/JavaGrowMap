package com.devil.basic.design.strategy;

/**
 * 策略测试
 *
 * @author Devil
 * @date Created in 2021/7/22 13:31
 */
public class StrategyTest {

    public static void main(String[] args) {
        Config config = ConfigFactory.DEFAULT.create(ConfigType.BETA);
        System.out.println(config.getConfig());
    }

}
