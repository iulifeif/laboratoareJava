package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameServer<Mutable> {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public AtomicBoolean serverOn = new AtomicBoolean(true);
    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            //the server reads from the given port
            serverSocket = new ServerSocket(PORT);
            while (serverOn.get()) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's requests in a new thread
                new ClientThread(socket, serverOn).run();
                System.out.println("valoare la server: " + serverOn.get());
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
            System.out.println("The server is shut down! " +
                                "Client write command \"stop\"");
        }
    }
}
