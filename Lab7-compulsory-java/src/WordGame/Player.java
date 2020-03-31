package WordGame;

import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;

    //a player must to have a name
    Player(String name) {
        this.name = name;
    }

    //this function extract letters, display the words and stop the game when player make a word with length k
    private boolean createSubmitWord() throws InterruptedException {
        List extracted = game.getLetters().extractLetters(1);
        //this function stop the game
        if (extracted.isEmpty()) {
            return false;
        }
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            word.append(extracted.get(0));
        }

        game.getBoard().addWordToPlayer(this, word.toString());
        Thread.sleep(300);
        return true;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame( Game game ) {
        this.game = game;
    }

    //implement the toString() method
    @Override
    public String toString() {
        return name;
    }

    //implement the run() method, that will repeatedly create and submit words
    @Override
    public void run() {
        while (true) {
            try {
                if (!createSubmitWord()) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
