package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket server = serverSocket.accept();
        System.out.println("连接成功！");

        WriteOnSocket write = new WriteOnSocket(server);
        ReadFromSocket read = new ReadFromSocket(server);
        write.start();
        read.start();
    }
}

class WriteOnSocket extends Thread {  //写线程
    Socket server = null;

    WriteOnSocket (Socket _server){
        this.server = _server;
    }

    @Override
    public void run() {
        while (server == null) {

        }
        DataOutputStream out = null; //写
        try {
            out = new DataOutputStream(server.getOutputStream());
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
    Socket server = null;

    ReadFromSocket(Socket _server) {
        this.server = _server;
    }

    @Override
    public void run() {
        while (server == null) {
        }
        DataInputStream in = null; //读
        try {
            in = new DataInputStream(server.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                System.out.println("客户端: "+in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}




