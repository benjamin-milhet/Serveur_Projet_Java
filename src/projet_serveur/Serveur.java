package projet_serveur;

import java.net.*;
import java.io.*;

public class Serveur {

    public Serveur() throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            Socket client = socket.accept();
            System.out.println(client.getInetAddress().getHostAddress());
            System.out.println("Client connecté");
            //new Thread(new ServeurThread(client)).start();
        }
    }
}

