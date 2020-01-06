package com.company.ClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int port = 9910;

    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(port);
        Socket soc;
        int  count=0;
        while (true){

            //********* Receive Data
            System.out.println("=========>" +
                    "" +
                    "" +
                    "" +
                    " Server Up");
            soc = s.accept();
            count++;
            System.out.println("=====> New CLient ");

            DataInputStream dis = new DataInputStream(soc.getInputStream());
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            Thread t = new SocketTread( dis, dos,soc);
            t.start();
        }
    }
}