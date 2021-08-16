//package com.isiyi.aio;
//
//import io.netty.channel.ChannelHandler;
//
//import java.nio.channels.AsynchronousSocketChannel;
//import java.nio.channels.CompletionHandler;
//import java.nio.charset.Charset;
//
///**
// * 类描述
// * <p></p>
// *
// * @version 1.0.0
// * @description: ChannelAdapter
// * @author: 向鹏飞
// * @since: 2021/7/18
// */
//public abstract class ChannelAdapter implements CompletionHandler<Integer, Object> {
//
//    private AsynchronousSocketChannel channel;
//    private Charset charset;
//
//    public ChannelAdapter(AsynchronousSocketChannel channel, Charset charset) {
//        this.channel = channel;
//        this.charset = charset;
//        if (channel.isOpen()) {
//            channelActive(new ChannelHandler(channel, charset));
//        }
//    }
//    @Override
//    public void completed(Integer result, Object attachment) {
//
//    }
//
//
//    @Override
//    public void failed(Throwable exc, Object attachment) {
//        exc.getStackTrace();
//    }
//
//    public abstract void channelActive(ChannelHandler ctx);
//
//    public abstract void channelInactive(ChannelHandler ctx);
//
//    // 读取消息抽象类
//    public abstract void channelRead(ChannelHandler ctx, Object msg);
//
//
//}
