package com.company.ClientServer;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final int port = 9910;

    public static void main(String[] args) throws Exception {


        Scanner scn = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);
            //********************SenD Object
            Socket socket = new Socket(InetAddress.getLocalHost(), port);
            System.out.println(socket);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        while (true){
                System.out.println(dis.readUTF());
            String tosend = scn.nextLine();
            dos.writeUTF(tosend);

            if(tosend.equals("Exit"))
            {
                System.out.println("Closing this connection : " + socket);
                socket.close();
                System.out.println("Connection closed");
                break;
            }

                System.out.println("donnez Le prmier :");String  a = scn.nextLine();
                System.out.println("donnez Le deuxiemme : ");String b = scn2.nextLine();
                new ObjectOutputStream(socket.getOutputStream()).writeObject(new note(a, b));

                String received = dis.readUTF();
                System.out.println(received);
            }
    }
}