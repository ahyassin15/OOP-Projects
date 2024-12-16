package project2;

public class Board {
    
    //2D array for tic-tac-toe grid of char type
    private char[][] grid;

    //Constructor to initialize the board
    public Board(int size) {

        grid = new char[size][size]; //Initialize NxN grid

        //Loop through each row and column and fill grid with '-'
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = '-';
            }
        }
    }

    //Getter method for the grid
    public char[][] getGrid() {
        return grid;
    }

    //Getter method for the grid size
    public int getGridSize() {
        return getGrid().length;
    }

    //Displays current state of the grid
    public void display() {

        //Loop throught each row and column of the grid
        for (int row = 0; row < getGridSize(); row++) {
            for (int col = 0; col < getGridSize(); col++) {
                
                System.out.print(getGrid()[row][col]); //Print the value at the current cell

                if (col < (getGridSize() - 1)) {
                    System.out.print(" | "); //Add separator for all columns except the last one
                }
            }
            System.out.println(); //Move to the next line after completing a row
            
            //Add a row separator for all rows except the last one
            if (row < (getGridSize() - 1)) {
                for (int dash = 0; dash < getGridSize() * 4 - 1; dash++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    //Places player's symbol at the specified position
    public void place(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }

    //Checks if the specified cell is within bounds and unoccupied
    public boolean checkBounds(int row, int col) {
        if (row > (getGridSize() - 1) || col > (getGridSize() - 1) || row < 0 || col < 0) {
            System.out.println("Error: Row or column out of bounds");
            return false;
        }
        return grid[row][col] == '-'; //Return true if the cell is empty
    }

    //Checks if the specified player has won the game
    public boolean checkForWin(char player) {
        //Check rows for a win
        for (int i = 0; i < getGridSize(); i++) {
            char symbol = getGrid()[i][0];  //Check the first cell in the row
            if (symbol == '-') {            //Skip empty rows
                continue;
            }
            for (int j = 1; j < getGridSize(); j++) {
                //Break if cells don't match
                if (!(getGrid()[i][j] == symbol)) {
                    break;
                }
                //If all cells match, return true
                if (j == getGridSize() - 1) {
                    return true;
                }
            }
        }

        //Check columns for a win
        for (int i = 0; i < getGridSize(); i++) {
            char symbol = getGrid()[0][i];  //Check the first cell in the column
            if (symbol == '-') {            //Skip empty columns
                continue;
            }
            for (int j = 1; j < getGridSize(); j++) {
                if (!(getGrid()[j][i] == symbol)) {
                    break;
                }
                if (j == getGridSize() - 1) {
                    return true;
                }
            }
        }

        //Check diagonals for a win
        char symbol = getGrid()[0][0];  //Check the top-left diagonal  
        if (!(symbol == '-')) {         //Skip empty diagonal
            for (int i = 1; i < getGridSize(); i++) {
                if (!(getGrid()[i][i] == symbol)) {
                    break;
                }
                if (i == getGridSize() - 1) {
                    return true;
                }
            }
            //Check the top-right diagonal
            for (int i = 1; i < getGridSize(); i++) {
                if (!(getGrid()[i][getGridSize() - 1 - i] == symbol)) {
                    break;
                }
                if (i == getGridSize() - 1) {
                    return true;
                }
            }
        }
        return false;   //Return false if no winning condition met
    }

    //Resets the board to its initial state
    public char[][] resetBoard() {
        for (int row = 0; row < getGridSize(); row++) {
            for (int col = 0; col < getGridSize(); col++) {
                grid[row][col] = '-'; //Reset each cell to default symbol
            }
        }
        return grid; //Return grid's initial state
    }
}