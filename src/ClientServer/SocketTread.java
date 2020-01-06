package com.company.ClientServer;

import javax.print.DocFlavor;
import java.io.*;
import java.net.Socket;
import java.util.Date;

public class SocketTread extends Thread {

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    note nn;

    public SocketTread(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Socket socket) {
        this.dis = dataInputStream;
        this.dos = dataOutputStream;
        this.s = socket;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        while (true)
        {
            try {
                dos.writeUTF("What do you want to Calculate ?[Yes | No]..\n"+ "Type Exit to terminate connection.");

                received = dis.readUTF();

                if(received.equals("Exit"))
                {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }


                switch (received) {

                    case "Yes" :
                       note nn =  (note) new ObjectInputStream(s.getInputStream()).readObject();
                       int  n = nn.somm();
                       dos.writeUTF(String.valueOf(n));
                        break;
                    case "No":
                        break;
                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        try
        {
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
