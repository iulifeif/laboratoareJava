package WordGame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> wordList;

    Board() {
        wordList = new ArrayList<>();
    }
    //this function synchronize the players and add words
    synchronized final void addWordToPlayer(Player player , String word ) throws NullPointerException {
        if ( word == null ) {
            throw new NullPointerException("Please enter a word!");
        }
        if( player == null ) {
            throw new NullPointerException("An existing player want to introduce a word!");
        }
        wordList.add(word);
        System.out.println("Player " + player.getName() + " submitted the word " + word );
    }
}
