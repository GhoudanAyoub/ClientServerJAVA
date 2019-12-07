package ClientServer;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * GHOUDAN Ayoub
 * **/
public class Client {
    static final int port = 8080;

    public static void main(String[] args) throws Exception {

        int max = 10;
        int min = 1;
        int range = max - min + 1;

        //********************SenD Object
        Socket socket = new Socket(InetAddress.getLocalHost(), port);
        System.out.println(socket);
        int a = (int)(Math.random() * range) + min;
        int bb = (int)(Math.random() * range) + min;

        note n  =new note(a,bb);
        ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(n);
        objectOutputStream.close();

        //********************
        ServerSocket  s = new ServerSocket(3300);
        socket = s.accept();

        String nn ;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while ((nn =bufferedReader.readLine())!=null){
            System.out.println("THE SUM OF ("+n.getA()+" + "+n.getB()+") IS = "+Integer.parseInt(nn));
        }

        /**
         * It Gives Null All The Time
         * **/

    }
}
