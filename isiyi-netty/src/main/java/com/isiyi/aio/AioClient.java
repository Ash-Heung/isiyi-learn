//package com.isiyi.aio;
//
//import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.channels.AsynchronousSocketChannel;
//import java.nio.charset.Charset;
//import java.util.concurrent.Future;
//
///**
// * 类描述
// * <p></p>
// *
// * @version 1.0.0
// * @description: AioClient
// * @author: 向鹏飞
// * @since: 2021/7/18
// */
//public class AioClient {
//
//    public static void main(String[] args) throws Exception {
//        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
//        Future<Void> future = socketChannel.connect(new InetSocketAddress("127.0.0.1", 7397));
//        System.out.println("itstack-demo-netty client start done. {关注公众号：bugstack虫洞栈 | 欢迎关注&获取源码}");
//        future.get();
//        socketChannel.read(ByteBuffer.allocate(1024), null, new AioClientHandler(socketChannel, Charset.forName("utf-8")));
//        Thread.sleep(100000);
//    }
//
//}
