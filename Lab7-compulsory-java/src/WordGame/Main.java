package WordGame;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        //create a new Game
        Game game = new Game();
        game.setLetters(new Letters());
        game.setBoard(new Board());
        //set k number for progresion
        game.setNrProgresion(6);

        try {
            //add words from txt
            game.setDictionary(new Dictionary());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Please check the file words.txt");
        }

        //add players
        game.addPlayer(new Player("1"));
        game.addPlayer(new Player("2"));

        //and the game can start
        game.start();
    }
}
