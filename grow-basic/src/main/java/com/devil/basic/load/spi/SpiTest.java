package com.devil.basic.load.spi;

import java.util.ServiceLoader;

/**
 * spi测试
 *
 * @author Devil
 * @date Created in 2021/7/23 11:12
 */
public class SpiTest {
    
    public static void main(String[] args) {
        ServiceLoader<UploadCdn> uploadCdns = ServiceLoader.load(UploadCdn.class);
        for (UploadCdn cdn : uploadCdns) {
            cdn.upload();
        }
    }
    
}
