package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket;}
    public void run () {
        try {
            //get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            //send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //read each line from the client
            String request = in.readLine();
            String raspuns;
            //server will be stopped when receive the "stop" command
            while(!request.equalsIgnoreCase("stop")){
                //server read the request and send a message
                System.out.println("Client send the request: " + request);
                raspuns = "Server received the request: " + request;
                out.println(raspuns);
                out.flush();
                //read the following command
                request = in.readLine();
            }
            //when server receives the "stop" command he goes out and sends an answer
            raspuns = "Server stopped";
            System.out.println(raspuns);
            out.println(raspuns);
            out.flush();
            //the socket will close the communication with the client
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}
