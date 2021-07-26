package com.devil.netty;

/**
 * rpc响应
 *
 * @author Devil
 * @date Created in 2021/7/26 16:58
 */
public class RpcResponse {

    private String id;

    private String data;

    public RpcResponse() {
    }

    public RpcResponse(String id, String data) {
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
     * @return the name
     */
    public String getData() {
        return data;
    }

    /**
     * @param data : the name to set
     */
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RpcResponse{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
