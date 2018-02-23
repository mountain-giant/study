package org.rpc.example.demo;

import org.rpc.remoting.netty.NettyServerConfig;
import org.rpc.rpc.model.ServiceWrapper;
import org.rpc.rpc.provider.DefaultProvider;
import org.rpc.rpc.provider.Provider;

public class ProviderExample {

    public static void main(String[] args) {
        NettyServerConfig config = new NettyServerConfig();
        Provider provider = new DefaultProvider(config);
        provider.start();

        HelloService helloService = new HelloServiceImpl();

        // 注册到本地容器 未发布到注册中心
        ServiceWrapper serviceWrapper = provider.serviceRegistry()
                .provider(helloService)
                .interfaceClass(HelloService.class)
                .providerName("org.rpc.example.demo.HelloService")
                .group("test")
                .version("1.0.0")
                .register();

    }
}
