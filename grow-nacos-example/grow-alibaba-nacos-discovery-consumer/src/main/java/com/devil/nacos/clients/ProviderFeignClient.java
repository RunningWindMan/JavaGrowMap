package com.devil.nacos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Devil
 * @date Created in 2022/3/10 15:28
 */
@FeignClient(value = "grow-alibaba-nacos-discovery-provider")
public interface ProviderFeignClient {
    
    @GetMapping(value = "/provider/get")
    String get();
    
}
