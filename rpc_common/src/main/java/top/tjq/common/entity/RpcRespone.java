package entity;

import enumer.ResponeCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Create by moling_tjq on 2020-08-23
 *
 * 用于封装一些基本的rpc调用结果
 */
@Data

public class RpcRespone<T> implements Serializable{

    /**
     * 无参构造函数
     */
    public RpcRespone(){};
    /**
     * 服务调用状态码
     */
    private Integer statusCode;

    /**
     * 服务调用信息
     */
    private String messages;

    /**
     * 服务相应数据
     */
    private T data;

    /**
     * 封装调用成功信息
     */
    public static <T> RpcRespone<T> success(T data){
        RpcRespone<T> rpcRespone = new RpcRespone<T>();
        rpcRespone.setStatusCode(enumer.ResponeCode.SUCCESS.getCode());
        rpcRespone.setData(data);
        return rpcRespone;
    }

    /**
     * 封装调用错误信息
     */
    public static <T> RpcRespone<T> fail(T data){
        RpcRespone<T> rpcRespone = new RpcRespone<T>();
        rpcRespone.setStatusCode(ResponeCode.FAIL.getCode());
        rpcRespone.setData(data);
        return rpcRespone;
    }
}
