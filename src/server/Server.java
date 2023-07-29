package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import common.Buffer;

public class Server {
    private static final int PORT = 250887;
    private static final Buffer messageBuffer = new Buffer();

    public static void main(String[] args) throws IOException {//togliere throws per trycatch
        ServerSocket serverSocket = new ServerSocket(PORT);

        if(serverSocket.isBound()){
            System.out.println("Connessione effettuata");
        }
        else System.out.println("Qualcosa non va");

        while (true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connessione stabilita con: " + clientSocket);

            Thread clientThread = new Thread(new ClientHandler(clientSocket));
        }
    }
}
