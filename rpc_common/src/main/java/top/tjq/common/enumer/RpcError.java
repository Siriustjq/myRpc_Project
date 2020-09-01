package top.tjq.common.enumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Create by moling_tjq on 2020-09-01
 */
@Getter
@AllArgsConstructor
public enum RpcError {

    SERVICE_INVOCATION_FAILURE("服务调用出现失败"),
    SERVICE_NOT_FOUND("找不到对应的服务"),
    SERVICE_NOT_IMPLEMENT_ANY_INTERFACE("注册的服务未实现接口");

    private final String message;
}
