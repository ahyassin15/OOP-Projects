package project1;

import java.util.Random;

public class ComputerPlayer extends Player {
    
    //Declare Random object for generating random moves
    private Random random;

    //Constructor for initializing the ComputerPlayer with a symbol
    public ComputerPlayer(char symbol) {
        super(symbol);                  //Call constructor of superclass (Player)
        this.random = new Random();     //Initialize Random object
    }

    //Override getSymbol method to return player's symbol
    @Override
    public char getSymbol() {
        return symbol;
    }

    //Override makeMove method to perform a move for the computer
    @Override
    public boolean makeMove(Board board) {
        int row, col;

        //Continuously generate random moves until a valid move is found
        while (true) {
            //Generate random row and column indices
            row = random.nextInt(board.getGridSize());
            col = random.nextInt(board.getGridSize());

            // Check if the randomly selected cell is valid and unoccupied
            if (board.checkBounds(row, col)) {
                
                System.out.printf("Computer %s places move at (%d, %d)\n", getSymbol(), row+1, col+1); //Output computer's move
                
                board.place(row, col, symbol); //Place computer's symbol in the cell it randomly selected
                board.display();
                
                return false; //Move is successful
            }
        }
    }
}
