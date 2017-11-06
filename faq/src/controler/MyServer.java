package controler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * server端
 */
public class MyServer {

    public MyServer(){
    }

    public void toServe(){
        try {
            ServerSocket serverSocket = new ServerSocket(8018);
            System.out.println("服务器启动，等待链接....");
            Socket socket = serverSocket.accept();//

            BufferedReader in = null;
            PrintWriter out = null;

            if (socket.isConnected()){
                System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"连接成功");
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);//自动刷新
                out.println(socket.getLocalAddress().getHostAddress()+"连接成功！");

            }

            while (in.readLine()!=null){
                String msg = in.readLine();
                if (msg.equals("exit")){
                    out.println("bye");
                    System.out.println("断开连接");
                    break;
                }else {
                    out.println("response "+msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        MyServer server = new MyServer();
        server.toServe();
    }
}
