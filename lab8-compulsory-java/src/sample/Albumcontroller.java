package sample;

import sample_controller.AlbumController;
import sample_controller.ArtistController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class AlbumControllerDao implements Dao2<AlbumController> {

    @Override
    public void create(String name, int artistId, int releaseYear) {
        try {
            String url = "jdbc:mysql://localhost/java";
            Connection conn = DriverManager.getConnection(url,"dba", "sql");
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO albums " + "VALUES (name, artistId, releaseYear)");
            System.out.println("The values were added to the database albums.");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void findByArtist(int artistId) {
        try {
            String url = "jdbc:mysql://localhost/java";
            Connection conn = DriverManager.getConnection(url,"dba", "sql");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT name FROM albums WHERE id = id");
            while ( rs.next() ) {
                String nameData = rs.getString("name");
                System.out.println(nameData);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
