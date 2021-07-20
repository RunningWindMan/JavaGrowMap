package com.devil.spring.config;

import com.devil.spring.bean.DevilBean;
import com.devil.spring.bean.PrototypeBean;
import com.devil.spring.postprocessor.DevilPostProcessor;
import com.devil.spring.postprocessor.DevilRegistryPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Scope;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Random;

/**
 * 配置
 *
 * @author Devil
 * @date Created in 2021/7/14 21:26
 */
@Configuration(proxyBeanMethods = false)
public class DevilConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        Random random = new Random();
        int code = random.nextInt(100);
        return new PrototypeBean(code);
    }

    static class Registrar implements ImportBeanDefinitionRegistrar {

        private static final String BEAN_NAME = "devilPostProcessor";
        private static final String REGISTRY_BEAN_NAME = "devilRegistryPostProcessor";

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                            BeanDefinitionRegistry registry) {
            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
                    .genericBeanDefinition(DevilPostProcessor.class,
                            DevilPostProcessor::new)
                    .setRole(BeanDefinition.ROLE_INFRASTRUCTURE)
                    .getBeanDefinition();
            // 用户自定义false
            beanDefinition.setSynthetic(false);
            registry.registerBeanDefinition(BEAN_NAME, beanDefinition);
            registry.registerBeanDefinition(REGISTRY_BEAN_NAME, new RootBeanDefinition(DevilRegistryPostProcessor.class));
            registry.registerBeanDefinition("devilBean", new RootBeanDefinition(DevilBean.class));
        }
    }

}
