package Level2.HomeWork6;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        ClientHolder cli = new ClientHolder();
        System.out.println("Client started. Connecting to localhost: 8189");

        new Thread(() -> {
            try {
                cli.readMSG();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                cli.sendMSG();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ClientHolder {
    Socket socket = null;
    BufferedReader in = null;
    PrintWriter out= null;
    BufferedReader console = null;
    String userMSG, serverMSG;

    ClientHolder() throws IOException {
        socket = new Socket("localhost",8189);
        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    void sendMSG() throws IOException {
        while (true) {
            if ((userMSG = console.readLine()) != null) {
                out.println(userMSG);
                if (userMSG.equalsIgnoreCase("close") || userMSG.equalsIgnoreCase("exit")) {
                    close();
                }
            }
        }
    }

    void readMSG() throws IOException {
        while (true) {
            if ((serverMSG = in.readLine()) != null){
                System.out.println(serverMSG);
            }
        }
    }

    void close() throws IOException {
        out.close();
        in.close();
        console.close();
        socket.close();
    }
}