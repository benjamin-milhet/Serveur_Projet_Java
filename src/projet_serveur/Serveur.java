package projet_serveur;

import java.net.*;
import java.io.*;

public class Serveur {

    private ServerSocket serverSocket;
    private  Socket socket;

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    public Serveur() throws IOException {
        this.serverSocket = new ServerSocket(8080);

        try {

            while (!serverSocket.isClosed()) {
                // Will be closed in the Client Handler.
                this.socket = serverSocket.accept();
                System.out.println("A new client has connected!");

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                // The start method begins the execution of a thread.
                // When you call start() the run method is called.
                // The operating system schedules the threads.
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
