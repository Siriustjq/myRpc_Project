package top.tjq.common.exception;

import top.tjq.common.enumer.RpcError;

/**
 * Create by moling_tjq on 2020-09-01
 */
public class RpcException extends RuntimeException{
    public RpcException(RpcError error, String detail) {
        super(error.getMessage() + ": " + detail);
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcException(RpcError error) {
        super(error.getMessage());
    }
}
