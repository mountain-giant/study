package org.rpc.rpc.consumer;

import org.rpc.remoting.api.RpcClient;
import org.rpc.remoting.api.channel.ChannelGroup;
import org.rpc.remoting.netty.NettyClient;
import org.rpc.remoting.netty.NettyClientConfig;

public class DefaultConsumer implements Consumer {

    private String application;

    private RpcClient rpcClient;

    private ChannelGroup group;

    private NettyClientConfig config;

    public DefaultConsumer(String application, NettyClientConfig nettyClientConfig) {
        this.application = application;
        this.rpcClient = new NettyClient(nettyClientConfig);
    }

    @Override
    public RpcClient client() {
        return null;
    }

    @Override
    public void start() {
        rpcClient.start();
    }

    @Override
    public String application() {
        return application;
    }

}
