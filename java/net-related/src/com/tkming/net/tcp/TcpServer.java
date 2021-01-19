package com.tkming.net.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/19 9:51
 * @desc 暂无
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8002);
        Socket s = ss.accept();
        System.out.println("welcome to the java world!");

        InputStream in = s.getInputStream();
        BufferedReader buffIn = new BufferedReader(new InputStreamReader(in));

        OutputStream out = s.getOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);

        while (true) {
            String msg = buffIn.readLine();
            System.out.println("client said: " +msg);
            if ("quit".equalsIgnoreCase(msg)) {
                break;
            }
            dataOut.write((msg + "666" + System.lineSeparator()).getBytes());
        }

        in.close();
        out.close();
        s.close();
        ss.close();
    }
}
