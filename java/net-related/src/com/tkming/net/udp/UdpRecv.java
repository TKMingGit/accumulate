package com.tkming.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @version 1.0
 * @Author ZM461
 * @create 2021/1/18 16:37
 * @desc 暂无
 */
public class UdpRecv {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket ds = new DatagramSocket(8000);
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, 1024);
        System.out.println("receiver: i am waiting for data....");

        ds.receive(dp);
        String revMsg = new String(dp.getData(), 0, dp.getLength());
        System.out.println("receiver: i have received data that '" + revMsg + "' from " + dp.getAddress().getHostAddress() + ":" + dp.getPort());

        Thread.sleep(1000);
        System.out.println("receiver: i am sending data....");
        String sendMsg = "nice to meet you too";
        DatagramPacket dp2 = new DatagramPacket(sendMsg.getBytes(), 0, sendMsg.length(), InetAddress.getByName("127.0.0.1"), 8001);
        ds.send(dp2);
        System.out.println("receiver: i am sent finish!");
        ds.close();
    }
}
