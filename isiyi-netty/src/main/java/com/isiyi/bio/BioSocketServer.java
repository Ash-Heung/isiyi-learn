package com.isiyi.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * Bio server
 * <p></p>
 *
 * @version 1.0.0
 * @description: BioSocketServer
 * @author: 向鹏飞
 * @since: 2021/12/29
 */
public class BioSocketServer {

    public static void main(String[] args) throws Exception {
        // 创建一个新的serverSocket,用于监听指定端口上的连接请求
        ServerSocket serverSocket = new ServerSocket(7788);
        // 对  accept() 方法的调用将被阻塞，值到一个连接建立
        Socket socket = serverSocket.accept();
        //BufferedReader 和 PrintWriter 都派生于 Socket 套接字的流对象
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

        String request, response;
        // 循环处理开始
        while ((request = bufferedReader.readLine()) != null){
            // 终止处理条件
            if(Objects.equals("done", request)){
                break;
            }
            // 请求被传递给服务器处理方法
            response = processResponse(request);
            // 服务器的执行被发送给客户端
            printWriter.println(response);
        }


    }

    private static String processResponse(String request) {


        return "Response";
    }

}
