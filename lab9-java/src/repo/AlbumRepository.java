package repo;

import entity.Album;
import entity.Artist;

import java.sql.*;

public class AlbumRepository {
    public void connect() throws ClassNotFoundException, SQLException {
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost/java";
        Class.forName (myDriver);
        Connection conn = DriverManager.getConnection (myUrl, "dba", "sql");
    }
    public void disconnect() throws SQLException {
        String myUrl = "jdbc:mysql://localhost/java";
        Connection conn = DriverManager.getConnection (myUrl, "dba", "sql");
        conn.close();
    }
    public void create(Artist artist) throws ClassNotFoundException, SQLException {
        //save artist in database
        connect();
        String myUrl = "jdbc:mysql://localhost/java";
        Connection conn = DriverManager.getConnection (myUrl, "dba", "sql");
        // the mysql insert statement
        String query = " insert into albums (name, country)" + " values (artist.getName(), artist.getContry())";
        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        // execute the query
        preparedStmt.execute();
    }

    public void findById(int idAlbum) throws SQLException, ClassNotFoundException {
        connect();
        String myUrl = "jdbc:mysql://localhost/java";
        Connection conn = DriverManager.getConnection (myUrl, "dba", "sql");
        String query = "Select name, artist_id, release_year from albums where id = idAlbum";
        // create the java statement
        Statement st = conn.createStatement();
        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);
        // iterate through the java resultset
        while (rs.next())
        {
            String nameAlbum = rs.getString("name");
            Integer artistAlbum = rs.getInt("artist_id");
            Integer yearAlbum = rs.getInt("release_year");
            // print the results
            System.out.format("%s, %d, %d\n", nameAlbum, artistAlbum, yearAlbum);
        }
        st.close();
        disconnect();
    }

    public void findByName(String nameAlbum) throws SQLException, ClassNotFoundException {
        connect();
        String myUrl = "jdbc:mysql://localhost/java";
        Connection conn = DriverManager.getConnection (myUrl, "dba", "sql");
        String query = "Select artist_id, release_year from albums where name=nameAlbum";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
            Integer artistAlbum = rs.getInt("artist_id");
            Integer yearAlbum = rs.getInt("release_year");
            // print the results
            System.out.format("%s, %d, %d\n", nameAlbum, artistAlbum, yearAlbum);
        }
        st.close();
        disconnect();
    }
}
