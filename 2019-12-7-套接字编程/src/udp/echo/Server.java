package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static final Map<String ,String> dict = new HashMap<>();
    static {
        dict.put("cat","喵喵");
        dict.put("dog","汪汪");
        dict.put("pig","佩奇");
        dict.put("fish","好吃");
    }

    public static void main(String[] args) throws IOException {
       //1.新建一个DatagramSocket
        DatagramSocket udpServerSocket = new DatagramSocket(9898);
        while (true){
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer,
                    receiveBuffer.length
            );
            //2.等着客户端来撩
            udpServerSocket.receive(receivePacket);
            InetAddress clientAddress = receivePacket.getAddress();
            System.out.printf("我从%s:%d收到了消息%n",clientAddress.getHostAddress(),
                    receivePacket.getPort());
            System.out.printf("我一共收到了%d字节的数据%n",receivePacket.getLength());

            String message = new String(
                    receivePacket.getData(),
                    0,
                    receivePacket.getLength(),
                    "UTF-8"
            );
            System.out.println(message);
            String responseMessage = dict.getOrDefault(message,"听不懂");

            byte[] sendBuffer = responseMessage.getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    clientAddress,
                    receivePacket.getPort()
            );

            udpServerSocket.send(sendPacket);
        }
    }
}

/*
package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.新建一个DatagramSocket
        DatagramSocket udpServerSocket = new DatagramSocket(9898);
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receiverPacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
        //等着客户端来撩
        udpServerSocket.receive(receiverPacket);
        InetAddress clientAddress = receiverPacket.getAddress();
        System.out.printf("我从%s:%d收到了消息%n",clientAddress.getHostAddress(),receiverPacket.getPort());
        System.out.printf("我一共收到了%d字节的数据%n",receiverPacket.getLength());

        String message = new String(receiverPacket.getData(),0,receiverPacket.getLength(),
                "UTF-8");

        System.out.println(message);

        //发送
        byte[] sendBuffer = message.getBytes("UTF-8");
        DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                clientAddress,
                receiverPacket.getPort()
        );

        udpServerSocket.send(sendPacket);
        udpServerSocket.close();
    }
}
*/
