package Level2.HomeWork6;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerHolder s = new ServerHolder();
        s.start();
        s.catchClient();
        new Thread(() -> {
            while (true) {
                String txt = null;
                try {
                    txt = s.in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (txt != null) {
                    try {
                        s.sendMessage(txt);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            try {
                s.writeToConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ServerHolder {
    BufferedReader in = null;
    PrintWriter out = null;
    ServerSocket serverSocket = null;
    Socket socket = null;
    String input;
    BufferedReader console = null;

    void start() {
        try {
            serverSocket = new ServerSocket(8189);
        } catch (IOException e) {
            System.out.println("Can't open port 8189");
            System.exit(1);
        }
        System.out.print("Server started. Waiting for a client...");
    }

    void catchClient() throws IOException {
        try {
            socket = serverSocket.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            System.out.println("Can't accept");
            System.exit(1);
        }

        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);

        System.out.println("Wait for messages...");
    }

    void sendMessage(String msg) throws IOException {
        if (msg.equalsIgnoreCase("exit") | msg.equalsIgnoreCase("close")) close();
        out.println("Server: " + msg);
        System.out.println(msg);
    }

    void close() throws IOException {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

    void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMessage(txt);
        }
    }
}