package com.devil.rpc;

/**
 * @author Devil
 * @date Created in 2022/3/4 14:33
 */
public class DevilRpcServiceImpl implements IDevilRpcService {

    @Override
    public void hello() {
        System.out.println("Devil RPC Service!");
    }

}
