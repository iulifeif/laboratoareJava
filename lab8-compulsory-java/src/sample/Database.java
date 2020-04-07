package sample;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

//    to create database and user and add tables:

//    Create database MusicAlbums;
//
//    create user 'dba'@'localhost' identified BY 'sql';
//
//    use MusicAlbums;
//
//    create table artists(
//            id integer not null,
//            name varchar(100) not null,
//    country varchar(100),
//    primary key (id)
//);
//    create table albums(
//            id integer not null,
//            name varchar(100) not null,
//    artist_id integer not null,
//    release_year integer,
//    primary key (id)
//);

    private static Database db_conn = null;
    String url = "jdbc:mysql://localhost/java" ;

    private void open(){
        try {
            Database db_conn = (Database) DriverManager.getConnection(url, "dba", "sql");
            System.out.println("Connection to db was made.");
        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
    }
    private void close() {
        db_conn.close();
        System.out.println("Connection to db was closed.");
    }
}
