package com.tkming.net.bio.udp;

import java.io.IOException;
import java.net.*;

/**
 * @version 1.0
 * @Author ZM461
 * @create 2021/1/18 16:39
 * @desc 暂无
 */
public class UdpSend {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket ds = new DatagramSocket(8001);
        String sendMsg = "hello, nice to meet you";
        DatagramPacket dp = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), InetAddress.getByName("127.0.0.1"), 8000);

        System.out.println("sender: i am sending data....");
        ds.send(dp);
        System.out.println("sender: i am sent finish!");

        Thread.sleep(1000);
        System.out.println("sender: i am waiting for data....");
        DatagramPacket dp2 = new DatagramPacket(new byte[1024], 1024);
        ds.receive(dp2);

        String rcvMsg = new String(dp2.getData(), 0 ,dp2.getLength());
        System.out.println("sender: i have received data that '" + rcvMsg + "' from " + dp2.getAddress().getHostAddress() + ":" + dp2.getPort());
        System.out.println();

        ds.close();
        System.out.println("sender: i am received finish!");
    }
}
