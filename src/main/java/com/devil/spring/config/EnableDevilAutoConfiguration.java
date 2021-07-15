package com.devil.spring.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 配置注解
 *
 * @author devil
 * @date Created in 2021/7/15 9:27
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DevilConfiguration.Registrar.class})
public @interface EnableDevilAutoConfiguration {

}
