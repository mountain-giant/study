package org.rpc.rpc.consumer;

import org.rpc.comm.UnresolvedAddress;
import org.rpc.register.NotifyListener;
import org.rpc.register.model.RegisterMeta;
import org.rpc.remoting.api.Directory;
import org.rpc.remoting.api.RpcClient;

import java.util.List;

public interface Consumer {

    RpcClient client() ;

    String application();

    /**
     * 直连调用
     * @param address
     */
    void connect(UnresolvedAddress address);

    /**
     * 连接到注册中心
     * @param address
     */
    void connectToRegistryServer(String address);

    /**
     * 从注册中心订阅一个服务.
     */
    void subscribe(Directory directory, NotifyListener listener);

    /**
     * 查找服务
     *
     * @param registerMeta
     * @return
     */
    List<RegisterMeta> lookup(RegisterMeta registerMeta);

}
