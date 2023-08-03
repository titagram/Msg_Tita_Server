package server;

import common.Buffer;
import common.Messaggio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//utilizzerò XML
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String messaggioDaClient;
            while ((messaggioDaClient = reader.readLine()) != null) {

                if (messaggioDaClient.length() <= 1000) {
                    //System.out.println("***** TEST Messaggio ricevuto dal client: " + messaggioDaClient + "*****");//TEST
                    Buffer.aggiungiMessaggio(messaggioDaClient);
                    writer.println("Risposta dal server: messaggio ricevuto");
                } else writer.println("Risposta dal server: messaggio troppo lungo");
            }
            reader.close();
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
