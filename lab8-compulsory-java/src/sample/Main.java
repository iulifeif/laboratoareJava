package sample;


import javafx.application.Application;
import javafx.stage.Stage;
import sample_controller.AlbumController;
import sample_controller.ArtistController;

public class Main extends Application {
    public static void main(String[] args) {
        ArtistController artist1 = new ArtistController();
        ArtistController artist2 = new ArtistController();
        AlbumController album1 = new AlbumController();
        AlbumController album2 = new AlbumController();
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Start the program.");
    }
}
