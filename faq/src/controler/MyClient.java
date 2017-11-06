package controler;

import java.io.*;
import java.net.Socket;

/**
 * client
 */
public class MyClient {
    private static final String URL = "127.0.0.1";

    public MyClient() {
    }

    public void toReuest() {
        try {
            Socket socket = new Socket(URL,8018);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            System.out.println("服务器返回的消息是："+in.readLine());

            while (input.readLine()!=null){
                String inMsg,inputMsg;
                inputMsg = input.readLine();//从键盘输入
                out.write(inputMsg);//传给服务器

                inMsg = in.readLine();
                if (inMsg.equals("bye")){
                    break;
                }
                System.out.println("服务器返回的数据是："+inMsg);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MyClient client = new MyClient();
        client.toReuest();
    }
}
