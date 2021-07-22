package com.devil.basic.design.strategy;

/**
 * @author Devil
 * @date Created in 2021/7/22 13:40
 */
public class DefaultConfig implements Config {

    @Override
    public String getConfig() {
        return "default";
    }
}
