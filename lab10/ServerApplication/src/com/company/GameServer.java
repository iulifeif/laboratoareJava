package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public boolean serverOn = true;
    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            //the server reads from the given port
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's requests in a new thread
                new ClientThread(socket).run();
                //if client write "stop", the thread closes
                //and command "break" break the loop
                break;
                //and after socket will be closed from block "finally"
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
