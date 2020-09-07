package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Create by moling_tjq on 2020-08-23
 *
 * 封装基本的rpc请求参数，可以理解为rpc传输协议的雏形
 */
@Data
@AllArgsConstructor
public class RpcRequest implements Serializable{
    /**
     * rpc请求的接口名称
     */
    private String interfaceName;

    /**
     * rpc请求的方法名称
     */
    private String methodName;

    /**
     * rpc请求的参数列表
     */
    private Object[] parameters;

    /**
     * rpc请求的参数类型
     */
    private Class<?>[] paramType;

    /**
     * 构造函数
     */
    public RpcRequest() {};
}
