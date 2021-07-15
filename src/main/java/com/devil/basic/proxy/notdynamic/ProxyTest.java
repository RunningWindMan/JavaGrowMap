package com.devil.basic.proxy.notdynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Devil
 * @date Created in 2021/7/15 12:01
 */
public class ProxyTest implements Domain {

    private static final Logger log = LoggerFactory.getLogger(ProxyTest.class);

    private TestDomain domain;

    public ProxyTest(TestDomain domain) {
        this.domain = domain;
    }

    @Override
    public String get() {
        log.info("proxy start -- == ++");
        domain.get();
        log.info("proxy end -- == ++");
        return null;
    }

    public static void main(String[] args) {
        TestDomain testDomain = new TestDomain();
        Domain domain = new ProxyTest(testDomain);
        domain.get();
    }

}
