package com.tomcat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Date 2022/12/6
 */
public class TomcatServer {

    public static void main(String[] args) throws Exception{

        //创建一个8080 端口的socket
        ServerSocket serverSocket = new ServerSocket(8080);
        //判断是否关闭了
        while (!serverSocket.isClosed()){
            //使用socket进行通信
            Socket socket = serverSocket.accept();
            //获得输入流
            InputStream inputStream = socket.getInputStream();
            System.out.println("执行客户请求:"+Thread.currentThread());
            System.out.println("收到客户请求");
            //读取inputstream的内容
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            String msg=null;
            while((msg=reader.readLine())!=null){
                if(msg.length()==0) break;
                System.out.println(msg);
            }
            //返回outputstream
            String resp="OK";
            OutputStream outputStream=socket.getOutputStream();
            System.out.println(resp);
            outputStream.write(resp.getBytes());
            outputStream.flush();
            outputStream.close();
            socket.close();
        }


    }


}
