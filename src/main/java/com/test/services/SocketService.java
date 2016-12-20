package com.test.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author xueyuan
 * @dater 2016-12-19 0019.
 */

public class SocketService implements Runnable {

    //public static List<Socket> socketList = new ArrayList<Socket>();
    // 定义当前线程处理的Socket
    Socket socket = null;
    // 该线程所处理的Socket所对应的输入流
    BufferedReader br = null;

 /*   public int port = 43333;
    ServerSocket server;*/

    public SocketService(Socket socket) {
        // this.server = server;
      /*  ServerSocket server = null;
        Socket sockets = null;*/

        this.socket = socket;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        System.out.println("进入了Thread 的run！");
       /*  try {
           server = new ServerSocket(port);
            while (true) {
                System.out.println("accept 监听！");
                socket = server.accept();
                socketList.add(socket);
                System.out.println("accept 已经连通！");

                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));*/

        System.out.println("SocketService 线程");
        String content = null;
        //采用循环不断的从Socket中读取客户端发送过来的数据
        while ((content = readFromClient()) != null) {
            System.out.println("SocketService while中");
            //遍历socketList中的每个Socket
            //将读取到的内容每个向Socket发送一次
            for (Socket s : MySocket.socketList) {
                OutputStream os;
                try {
                    os = s.getOutputStream();
                    System.out.println(os.toString());
                    os.write((content + "\n").getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        //}

       /* } catch (IOException e) {
            e.printStackTrace();
        }*/
        //sockets = server.accept();

    }

    // 定义读取客户端的信息

    public String readFromClient() {
        try {
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
