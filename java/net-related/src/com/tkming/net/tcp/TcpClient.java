package com.tkming.net.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/19 9:53
 * @desc 暂无
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getByName("127.0.0.1"), 8002);
        InputStream in = s.getInputStream();
        BufferedReader buffIn = new BufferedReader(new InputStreamReader(in));

        OutputStream out = s.getOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);

        BufferedReader buffSysIn = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String msg = buffSysIn.readLine();
            dataOut.write((msg + System.lineSeparator()).getBytes());
            if ("quit".equalsIgnoreCase(msg)) {
                break;
            } else {
                System.out.println("server said: " + buffIn.readLine());
            }
        }

        in.close();
        out.close();
        buffSysIn.close();
        s.close();
    }
}
