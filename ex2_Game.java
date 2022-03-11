package snakes;

import snakes.squares.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private List<ISquare> squares;
    private int size;
    private Queue<Player> players;
    private Player winner;
    private Die die;


    private boolean invariant() {
        return squares.size() > 3
                && size == squares.size()
                && players.size() >= 1;
    }

    public Game(int size, Player[] initPlayers) {
        this.size = size;
        this.addSquares(size);
        this.addPlayers(initPlayers);
        this.die = new Die();
        assert invariant();
    }

    public boolean isValidPosition(int position) {
        return position >= 1 && position <= size;
    }

    /**
     * TODO : check code, task 4 of exercise implemented?
     */


    public static void main(String args[]) {
        Player[] players = { new Player("Jack"), new Player("Jill") };
        Game game = new Game(15, players);
        game.setSquareToLadder(2, 4);
        game.setSquareToLadder(6, 2);
        game.setSquareToSnake(11, -6);
        game.setSquare(3, new InstantLoseSquare(game, 3));
        game.setSquare(4, new SleepSquare(game, 4));
        game.setSquare(5, new SleepSquare(game, 5));
        game.setSquare(8, new AlarmSquare(game, 8));
        game.setSquare(12, new AlarmSquare(game, 12));
        game.play();
    }

    public void play() {
        System.out.println("Initial state: " + this);
        while (this.notOver()) {
            int roll = die.roll();
            System.out.println(this.currentPlayer() + " rolls " + roll + ":  " + this);
            this.movePlayer(roll);
        }
        System.out.println("Final state:   " + this);
        System.out.println(this.winner() + " wins!");
    }

    public boolean notOver() {
        return winner == null;
    }

    public boolean isOver() {
        return !this.notOver();
    }

    public Player currentPlayer() {
        return players.peek();
    }

    //TODO : check code
    public void movePlayer(int roll) {
        assert roll >= 1 && roll <= 6;

        Player currentPlayer = players.peek(); // looks who is at the front of the queue without removing him
        currentPlayer.moveForward(roll);
        rotatePlayerQueue();
        if (currentPlayer.wins()) {
            winner = currentPlayer;
        }
        if(players.peek().getSleepTimer() >= 1){ //checks whether the currentPlayer is asleep
            currentPlayer.sleepATurn(); //spends a turn of the sleep timer
            rotatePlayerQueue();
        }
        assert invariant();
    }

    private void rotatePlayerQueue() {
        Player currentPlayer = players.remove(); // remove player from front of queue
        players.add(currentPlayer); // and add him to the back of the queue
    }

    public void setSquare(int position, ISquare square) {
        // Do not change the type of the first or last square!
        assert !this.getSquare(position).isLastSquare()
                && !this.getSquare(position).isFirstSquare();
        this.initSquare(position, square);
        assert invariant();
    }

    public Player winner() {
        return this.winner;
    }

    public ISquare firstSquare() {
        return squares.get(0);
    }

    public ISquare getSquare(int position) {
        assert this.isValidPosition(position);
        return squares.get(position - 1);
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (ISquare square : squares) {
            buffer.append(square.toString());
        }
        return buffer.toString();
    }

    private void addSquares(int size) {
        squares = new ArrayList<ISquare>();
        for (int i = 0; i < size; i++) {
            StandardSquare square = new StandardSquare(this, i + 1);
            squares.add(square);
        }
        this.initSquare(1, new FirstSquare(this, 1));
        this.initSquare(size, new LastSquare(this, size));
    }

    private void addPlayers(Player[] initPlayers) {
        players = new LinkedList<Player>();
        for (Player player : initPlayers) {
            player.joinGame(this);
            players.add(player);
        }
    }

    private void initSquare(int position, ISquare square) {
        assert this.isValidPosition(position) && square != null;
        squares.set(position - 1, square);
    }

    public void setSquareToLadder(int position, int transport) {
        this.setSquare(position, new LadderSquare(transport, this, position));
    }

    public void setSquareToSnake(int position, int transport) {
        this.setSquare(position, new SnakeSquare(transport, this, position));
    }

    public ISquare findSquare(int position, int moves) {
        assert position + moves <= 2 * size - 1; // can't go more than size-1 moves backwards past end
        int target = position + moves;
        if (target > size) { // reverse direction if we go past the end
            target = size - (target - size);
        }
        return this.getSquare(target);
    }

    public Die getDie() {
        return die;
    }

    //TODO : check code
    public void wakeAllPlayers(){
        for(Player player : players){
            player.wake();
        }
    }
    /**
     * pretty messi code -.-
     * TODO : check code
     */
    public boolean allLostExceptOne(){
        int countLost = 0;
        Player tempWinner = null;
        for(Player player : players){
            if(player.hasLost()){
                countLost++; //counts the amount of players that have lost
            }else
                tempWinner = player;
        }
        if(countLost == players.size()-1)
            this.winner = tempWinner;
        return countLost == players.size()-1; //if all but one have lost he is the winner
    }
}


//fighting!
