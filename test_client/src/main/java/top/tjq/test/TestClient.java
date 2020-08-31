import top.tjq.client.RpcClientProxy;
import top.tjq.api.*;

/**
 * Create by moling_tjq on 2020-08-23
 */
public class TestClient {
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");

        String res = helloService.hello(object);

        System.out.println(res);
    }
}
