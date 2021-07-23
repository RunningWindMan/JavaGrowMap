package com.devil.basic.load.spi;

/**
 * @author Devil
 * @date Created in 2021/7/23 11:24
 */
public class AliCdn implements UploadCdn {

    @Override
    public void upload() {
        System.out.println("Ali Cdn ");
    }
}
