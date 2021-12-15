package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",8888);

        WriteOnSocket write = new WriteOnSocket(client);
        ReadFromSocket read = new ReadFromSocket(client);
        read.start();
        write.start();

    }

}

class WriteOnSocket extends Thread {  //写线程
    Socket client = null;

    WriteOnSocket (Socket _client){
        this.client = _client;
    }

    @Override
    public void run() {
        while (client == null) {

        }
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            try {
                out.writeUTF(scanner.nextLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ReadFromSocket extends Thread {  //读线程
    Socket client = null;

    ReadFromSocket(Socket _server) {
        this.client = _server;
    }

    @Override
    public void run() {
        while (client == null) {
        }
        DataInputStream in = null;
        try {
            in = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                System.out.println("服务端: "+in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}





