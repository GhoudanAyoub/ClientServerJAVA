package ClientServer;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * GHOUDAN Ayoub
 * **/
public class Server {
    static final int port = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(port);
        Socket soc;
        while (true){

            //********* Receive Data
            System.out.println("=========> Server Up");
            soc = s.accept();
            System.out.println("=====> New CLient ");
            System.out.println("===> Start Operation ");
            ObjectInputStream objectInputStream = new ObjectInputStream(soc.getInputStream());
            note nn = (note) objectInputStream.readObject();
            int num = nn.somm();
            System.out.println("The Sum is : "+num);

            //***************Send Data
            System.out.println("--//Give Data To Clients");
            soc = new Socket(InetAddress.getLocalHost(),3300);
            BufferedOutputStream bufferedWriter = new BufferedOutputStream(soc.getOutputStream());
            bufferedWriter.write(num);
            soc.close();
            System.out.println("--//Data In Socket");
            System.out.println("=====>Clients Out\n");
        }
    }
}
