package com.test.services;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xueyuan
 * @dater 2016-12-19 0019.
 */
public class MySocket implements ServletContextListener {

    // 定义保存所有的Socket

    public static List<Socket> socketList = new ArrayList<Socket>();
    public int port = 43333;
    public Thread thread;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("启动了一个监听，启动了线程");

        thread = new Thread() {
            @Override
            public void run() {

                ServerSocket server;
                try {
                    server = new ServerSocket(port);
                    while (true) {
                        System.out.println("socket等待中……");
                        Socket socket = server.accept();
                        socketList.add(socket);
                        new Thread(new SocketService(socket)).start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        };
        thread.start();
   /*     ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
     /*   ServerSocket server = null;
        Socket sockets = null;
        try {
            server = new ServerSocket(port);
            //sockets = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        socketList.add(sockets);
        //每当客户端连接之后启动一条ServerThread线程为该客户端服务
        thread = new Thread(new SocketService(sockets));
        thread.start();*/
       /* SocketService socketService = new SocketService();
        socketService.start();*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("监听结束");
        //thread.interrupt();
    }
}
