package repo;

import entity.Artist;

import java.sql.*;

public class ArtistRepository {

    //am folosit baza de date mysql de data trecuta
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
        String query = " insert into artists (name, country)" + " values (artist.getName(), artist.getContry())";
        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        // execute the query
        preparedStmt.execute();
    }

    public void findById(int idArtist) throws SQLException, ClassNotFoundException {
        connect();
        String myUrl = "jdbc:mysql://localhost/java";
        Connection conn = DriverManager.getConnection (myUrl, "dba", "sql");
        String query = "Select name, country from artists where id = idArtist";
        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);

        // iterate through the java resultset
        while (rs.next())
        {
            int id = rs.getInt("id");
            String nameArtist = rs.getString("name");
            String countryArtist = rs.getString("country");

            // print the results
            System.out.format("%s, %s\n", idArtist, nameArtist, countryArtist);
        }
        st.close();
        disconnect();
    }
    public void findByName(String name){
        //trebuie sa retuneze o lista de entitati
    }
}
