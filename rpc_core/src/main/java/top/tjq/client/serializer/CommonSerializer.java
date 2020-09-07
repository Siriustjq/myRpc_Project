package top.tjq.client.serializer;

/**
 * Create by moling_tjq on 2020-09-04
 * 通用的序列化、反序列化接口
 */
public interface CommonSerializer {
    byte[] serialize(Object obj);

    Object deserialize(byte[] bytes, Class<?> clazz);

    int getCode();

    static CommonSerializer getByCode(int code) {
        switch (code) {
            case 1:
                return new JsonSerializer();
            default:
                return null;
        }
    }
}
