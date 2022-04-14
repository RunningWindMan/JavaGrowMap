package com.devil.basic.design.factory.abst;

/**
 * @author Devil
 * @date Created in 2021/7/22 14:33
 */
public class VipTicket implements Ticket {
    
    @Override
    public String price() {
        return "10";
    }
}
