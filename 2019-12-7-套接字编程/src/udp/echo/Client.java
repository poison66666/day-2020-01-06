package udp.echo;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpClientSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String message = scanner.nextLine();
            byte[] sendBuffer = message.getBytes("UTF-8");
            byte[] serverIP = new byte[4];
            serverIP[0] = (byte)192;
            serverIP[1] = (byte)168;
            serverIP[2] = (byte)43;
            serverIP[3] = (byte)140;
            InetAddress serverAddress = InetAddress.getByAddress(serverIP);
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    serverAddress,
                    9898
            );
            udpClientSocket.send(sendPacket);
            //接受对方回应的消息
            byte[] receiverBuffer = new byte[1024];
            DatagramPacket receiverPacket = new DatagramPacket(
                    receiverBuffer,
                    receiverBuffer.length
            );
            udpClientSocket.receive(receiverPacket);
            String responseMessage = new String(
                    receiverPacket.getData(),
                    0,
                    receiverPacket.getLength(),
                    "UTF-8"
            );
            System.out.println(responseMessage);
            }
        }
    }




/*
package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpClientSocket = new DatagramSocket();
        String message = "啦啦啦";
        byte[] sendBuffer = message.getBytes("UTF-8");
        // 127.0.0.1
        //发送
        byte[] serverIP = new byte[4];
        serverIP[0] = (byte)192;
        serverIP[1] = (byte)168;
        serverIP[2] = (byte)43;
        serverIP[3] = (byte)140;
        InetAddress serverAddress = InetAddress.getByAddress(serverIP);
        DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                serverAddress,
                9898
        );
        udpClientSocket.send(sendPacket);

        //接收对方回应的消息
        byte[] receiverBuffer = new byte[1024];
        DatagramPacket receiverPacket = new DatagramPacket(
                receiverBuffer, receiverBuffer.length
        );
        udpClientSocket.receive(receiverPacket);
        String responseMessage = new String(
                receiverPacket.getData(),
                0,
                receiverPacket.getLength(),
                "UTF-8"
        );
        System.out.println(responseMessage);
        udpClientSocket.close();
    }
}
*/
