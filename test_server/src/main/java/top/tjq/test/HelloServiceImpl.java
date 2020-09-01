package top.tjq.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.tjq.api.HelloObject;
import top.tjq.api.HelloService;

/**
 * Create by moling_tjq on 2020-08-24
 * 在测试服务端需要对客户端将要调用的方法进行实现
 */
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject object){
        logger.info("接收到：{}", object.getMessage());
        System.out.println("接收到：{"+object.getMessage()+"}");
        return "这是调用的返回值，id=" + object.getId();
    }
}
