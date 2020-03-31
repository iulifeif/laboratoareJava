package WordGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Letters letters;
    private Board board;
    private final List<Player> players = new ArrayList<>();
    private int nrProgresion;

    //the game must have players
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    //create getters and setters
    public Letters getLetters() {
        return letters;
    }

    public void setLetters(Letters letters) {
        this.letters = letters;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getNrProgresion() {
        return nrProgresion;
    }

    public void setNrProgresion(int nrProgresion) {
        this.nrProgresion = nrProgresion;
    }

    public void setDictionary(Dictionary dictionary) {
    }

    public List<Player> getPlayers() {
        return players;
    }
    //create the method that will start the game: start one thread for each player
    public void start() {
        for( Player p : players ) {
            new Thread(p).start();
        }
    }
}
