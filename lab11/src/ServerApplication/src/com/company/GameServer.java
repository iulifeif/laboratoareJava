package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameServer<Mutable> {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public AtomicBoolean serverOn = new AtomicBoolean(true);
    public String name;
    public int idName = -1;

    public InsertInDatabase(String name){
        String connectionUrl =
                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
                        + "database=AdventureWorks;"
                        + "user=db;"
                        + "password=sql;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        String insertSql = "INSERT INTO Players (name) VALUES " + this.name ";";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
    }

    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            //the server reads from the given port
            serverSocket = new ServerSocket(PORT);
            while (serverOn.get()) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                //save name in database
                idName ++;
                name = "player" + idName;
                InsertInDatabase(name);
                // Execute the client's requests in a new thread
                new ClientThread(socket, serverOn).run();
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
