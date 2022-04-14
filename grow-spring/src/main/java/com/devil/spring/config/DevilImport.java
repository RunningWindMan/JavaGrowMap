package com.devil.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Devil
 * @date Created in 2021/7/29 10:43
 */
public class DevilImport implements ImportSelector {
    
    private static final Logger log = LoggerFactory.getLogger(DevilImport.class);
    
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        log.info("导入import 或者 configuration");
        return new String[0];
    }
    
}
