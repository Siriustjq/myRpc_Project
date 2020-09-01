package top.tjq.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Create by moling_tjq on 2020-08-23
 *
 * 此类主要是用来封装发生rpc请求的过程
 */
public class RpcClient {
    private final static Logger logger = LoggerFactory.getLogger(RpcClient.class);

    /**
     * 利用Java序列化和socket对调用的参数请求进行传输
     * @param rpcRequest
     * @param host
     * @param port
     * @return
     */
    public Object sendRequest(entity.RpcRequest rpcRequest, String host, int port) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try (Socket socket = new Socket(host, port)) {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error("调用时有错误发生：", e);
            return null;
        }finally {
            logger.info("资源调用回收");
            if(objectOutputStream != null){
                objectOutputStream.close();
            }
        }
    }

}
