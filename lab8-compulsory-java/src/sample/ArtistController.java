package sample;
import sample_controller.ArtistController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class ArtistControllerDao implements sample.Dao<ArtistController> {

    @Override
    public void create(String name, String country) {
        try {
            String url = "jdbc:mysql://localhost/java";
            Connection conn = DriverManager.getConnection(url,"dba", "sql");
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO artists " + "VALUES (name, country)");
            System.out.println("The values were added to the database artists.");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void findByName(String name) {
        try {
            String url = "jdbc:mysql://localhost/java";
            Connection conn = DriverManager.getConnection(url,"dba", "sql");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT id FROM artist WHERE name = name");
            while ( rs.next() ) {
                String idData = rs.getString("id");
                System.out.println(idData);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}
