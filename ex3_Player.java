package snakes;

import snakes.squares.ISquare;
import snakes.squares.StandardSquare;

public class Player {

    private String name;
    private ISquare square;
    private int sleepTimer;
    private boolean lost = false;

    private boolean invariant() {
        return name != null
                && square != null;
    }

    public Player(String name) {
        this.name = name;
        // invariant holds only after joining a game
    }

    public void joinGame(Game game) {
        square = game.firstSquare();
        square.enter(this);
        assert invariant();
    }

    public int position() {
        assert invariant();
        return square.position();
    }

    public boolean moveForward(int moves) {
        assert moves > 0;
        square.leave(this);
        square = square.moveAndLand(moves);
        square.enter(this);
        return true;
    }

    public String toString() {
        return name;
    }

    public ISquare square() {
        return square;
    }

    public boolean wins() {
        return square.isLastSquare();
    }

    public void putToSleep(int time){this.sleepTimer = time;} //sets the sleep timer

    //TODO : check all of these following methods
    public void wake(){this.sleepTimer = 0;} //sets sleep timer to 0 (waking player up)

    public int getSleepTimer(){return this.sleepTimer;}

    public void sleepATurn(){this.sleepTimer--;} //spends a turn sleeping

    public void loose() {this.lost = true;} //makes a player loose and not able to move anymore

    public boolean hasLost(){return this.lost;}
}
