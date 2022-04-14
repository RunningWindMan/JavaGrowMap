package com.devil.basic.proxy.notdynamic;

/**
 * @author Devil
 * @date Created in 2021/7/15 12:01
 */
public class ProxyTest implements Domain {
    
    private TestDomain domain;
    
    public ProxyTest(TestDomain domain) {
        this.domain = domain;
    }
    
    @Override
    public String get() {
        System.out.println("proxy start -- == ++");
        domain.get();
        System.out.println("proxy end -- == ++");
        return null;
    }
    
    public static void main(String[] args) {
        TestDomain testDomain = new TestDomain();
        Domain domain = new ProxyTest(testDomain);
        domain.get();
    }
    
}
