package com.devil.basic.design.strategy;

/**
 * @author Devil
 * @date Created in 2021/7/22 13:41
 */
@FunctionalInterface
public interface ConfigFactory {

    ConfigFactory DEFAULT = (configType) -> {
        switch (configType) {
            case ALPHA:
                return new AlphaConfig();
            case BETA:
                return new BetaConfig();
            default:
                return new DefaultConfig();
        }
    };

    Config create(ConfigType configType);

}
