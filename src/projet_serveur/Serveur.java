package projet_serveur;

import java.net.*;
import java.io.*;

public class Serveur {

    private ServerSocket serverSocket;
    private  Socket socket;

    public Serveur() throws IOException {
        this.serverSocket = new ServerSocket(8080);

        try {

            while (!serverSocket.isClosed()) {
                this.socket = serverSocket.accept();
                System.out.println("A new client has connected!");

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (IOException e) {
            closeServerSocket();
        }
    }

    public void closeServerSocket() {
        try {
            if (this.serverSocket != null) {
                this.serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
