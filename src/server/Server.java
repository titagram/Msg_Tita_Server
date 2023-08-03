package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import common.Buffer;

public class Server {

    private static int PORT = 100;
    private static final int CONNESSIONI_MAX = 100;
    private static int conta_connessioni = 0;
    private static final Buffer messageBuffer = new Buffer();

    public static void main(String[] args) throws IOException {//togliere throws per trycatch
        ServerSocket serverSocket = null;

        while (conta_connessioni < CONNESSIONI_MAX) {
            try {
                serverSocket = new ServerSocket(PORT + conta_connessioni);
                System.out.println("Server in ascolto sulla porta: " + serverSocket.getLocalPort());

                Socket clientSocket = serverSocket.accept();
                System.out.println("Connessione stabilita con: " + clientSocket);

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();

                conta_connessioni++;
            } catch (IOException e) {
                System.out.println("Errore durante la creazione del ServerSocket sulla porta: " + (PORT + conta_connessioni));
            }
        }

        if (serverSocket != null) {
            serverSocket.close();
        }

        System.out.println("Limite di connessioni raggiunto. Il server è stato chiuso.");
    }

    }

