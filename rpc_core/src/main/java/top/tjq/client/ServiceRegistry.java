package top.tjq.client;

/**
 * Create by moling_tjq on 2020-09-01
 * 创建服务注册表接口
 */
public interface ServiceRegistry {
    /**
     *
     * @param service
     * @param <T>
     */
    <T> void register(T service);

    /**
     *
     * @param serviceName
     * @return 服务实体
     */
    Object getService(String serviceName);
}
