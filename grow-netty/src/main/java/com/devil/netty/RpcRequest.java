package com.devil.netty;

/**
 * rpc请求
 *
 * @author Devil
 * @date Created in 2021/7/26 17:00
 */
public class RpcRequest {
    
    private String id;
    
    private String data;
    
    public RpcRequest() {
    }
    
    public RpcRequest(String id, String data) {
        this.id = id;
        this.data = data;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * @param id : the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * @return the data
     */
    public String getData() {
        return data;
    }
    
    /**
     * @param data : the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "RpcRequest{" + "id='" + id + '\'' + ", data='" + data + '\'' + '}';
    }
}
