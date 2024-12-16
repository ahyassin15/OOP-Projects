package project2;

//Abstract class representing a generic Player
public abstract class Player {
    
    //Symbol representing the player (X or O)
    protected char symbol;

    //Constructor to initialize player's symbol
    public Player(char symbol) {
        this.symbol = symbol;
    }
    
    //Getter method to get player's symbol 
    public char getSymbol() {
        return symbol;
    }

    //Abstract method to define how a player makes a move in Player subclasses
    public abstract boolean makeMove(Board board);

}