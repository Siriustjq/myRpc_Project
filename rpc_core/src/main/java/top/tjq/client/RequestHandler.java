package top.tjq.client;

import enumer.ResponeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create by moling_tjq on 2020-09-01
 * 本部分是为了进一步降耦合，将实际反射调用的过程全部封装在这个类中
 */
public class RequestHandler {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    public Object handle(entity.RpcRequest rpcRequest, Object service) {
        Object result = null;
        try {
            result = invokeTargetMethod(rpcRequest, service);
            logger.info("服务:{} 成功调用方法:{}", rpcRequest.getInterfaceName(), rpcRequest.getMethodName());
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error("调用或发送时有错误发生：", e);
        } return result;
    }

    private Object invokeTargetMethod(entity.RpcRequest rpcRequest, Object service) throws IllegalAccessException, InvocationTargetException {
        Method method;
        try {
            method = service.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParamType());
        } catch (NoSuchMethodException e) {
            return entity.RpcRespone.fail(ResponeCode.NOT_FOUND_METHOD);
        }
        return method.invoke(service, rpcRequest.getParameters());
    }
}
