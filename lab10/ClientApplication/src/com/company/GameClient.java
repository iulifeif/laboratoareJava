package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public GameClient() throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                //a new socket is created
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
            //the client receive a message to know what to do
            System.out.println("Please write a command:");
            Scanner scanner = new Scanner(System.in);
            //read the command from the keyboard
            String request = scanner.nextLine();
            String response;
            //when client write "exit" communication will be stopped
            while (!request.equalsIgnoreCase("exit")){
                //client send the command to server
                out.println(request);
                //client read the response from server
                response = in.readLine();
                System.out.println(response);
//                this is in case the server shuts down and the client is still active
//                to shuts down both sides
//                if(request.equalsIgnoreCase("stop"))
//                    break;
                System.out.println("\nPlease write another command:");
                //read another command for server until "exit"
                request = scanner.nextLine();
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
