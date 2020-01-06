package tcp.http;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket tcpClientSocket = new Socket();
        byte[] ipv4 = {(byte)192,(byte)168,(byte)43,(byte)140};
        InetAddress serverAddress = InetAddress.getByAddress(ipv4);
        SocketAddress serverSocketAddress = new InetSocketAddress(serverAddress,8080);
        tcpClientSocket.connect(serverSocketAddress);

        while (true){
            System.out.println("请输入>");
            String request = scanner.nextLine();
            //通过字节流直接写入请求
            OutputStream os = tcpClientSocket.getOutputStream();
            PrintStream out = new PrintStream(os,true,"UTF-8");
            out.println(request);
            out.flush();
           // System.out.println("好友说：");
            //通过字节流，直接读取数据
            InputStream is = tcpClientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is,"UTF-8")
            );
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("好友说: " + line);
                System.out.print("请回复> ");
                String response = scanner.nextLine();
                out.println(response);
            }
            //String response = reader.readLine();
            //System.out.println(response);
        }
    }
}



/*
package tcp.http;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket tcpClientSocket = new Socket();
        byte[] ipv4 = {127, 0, 0, 1};
        InetAddress serverAddress = InetAddress.getByAddress(ipv4);
        SocketAddress serverSocketAddress
                = new InetSocketAddress(serverAddress, 8080);
        tcpClientSocket.connect(serverSocketAddress);

        while (true) {
            System.out.print("请输出> ");
            String request = scanner.nextLine();
            // 通过字节流直接写入请求
            OutputStream os = tcpClientSocket.getOutputStream();
            PrintStream out = new PrintStream(os, true, "UTF-8");
            out.println(request);

            // 通过字节流，直接读取数据
            InputStream is = tcpClientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, "UTF-8")
            );
            String response = reader.readLine();
            System.out.println(response);
        }
    }
}
*/
