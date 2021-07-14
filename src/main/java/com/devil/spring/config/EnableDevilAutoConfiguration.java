package com.devil.spring.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author thousandyears
 * @date Created in 2020/12/3 9:14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DevilConfiguration.Registrar.class})
public @interface EnableDevilAutoConfiguration {

}
