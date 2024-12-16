package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {

    //Constructor to initialize HumanPlayer with a symbol
    public HumanPlayer(char symbol) {
        super(symbol);
    }

    //Override makeMove method to handle the human player's move
    @Override
    public boolean makeMove(Board board) {
        int row, col;

        //Prompt human player to input their move in the correct format
        System.out.printf("%s, Choose row (1-3) and column (1-3) number to place a marker (Ensure to input in this format: row,column):\n", getSymbol());
        Scanner sc = new Scanner(System.in);
        String input = sc.next(); //Read user's input
        String[] parts = input.split(","); //Split the input into row and col parts

        //Validate the input format to ensure it contains exactly two parts (row and col)
        if (parts.length != 2) {
            System.out.println("Error: Invalid input");
            return true; //Repeat the turn if move unsuccessful
        }

        try {
            //Parse row and col from input, adjusting for 0-based indexing
            row = Integer.parseInt(parts[0].trim()) - 1;
            col = Integer.parseInt(parts[1].trim()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numbers");
            return true;
        }

        //Check if selected cell is within bounds and unoccupied
        if (board.checkBounds(row, col)) {
            board.place(row, col, symbol); //Place player's marker on the board
            board.display();
        } else {
            System.out.println("Error: Invalid move. Please try again.");
            return true;
        }

        return false; //Move was successful
    }
}