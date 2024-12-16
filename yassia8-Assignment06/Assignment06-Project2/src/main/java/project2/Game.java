package project2;

import java.util.Scanner;

public class Game {
    
    //Declare board and two players
    private Board board;
    private Player player1, player2;

    //Constructor to initialize the game with two players and the chosen size of the NxN board
    public Game(int size, Player player1, Player player2) {
        this.board = new Board(size);
        this.player1 = player1;
        this.player2 = player2;
    }

    //Starts and manages the main game loop
    public void startGameLoop() {
        //Display the symbols assigned to each player
        System.out.printf("Player 1: %s\n", player1.getSymbol());
        System.out.printf("Player 2: %s\n", player2.getSymbol());

        //Display initial empty board
        board.display();

        //Initialize count variable to track the number of moves
        int count = 0;

        //Game loop for up to N^2 moves, which is the maximum number of moves allowed in the game for NxN board
        while (count < Math.pow(board.getGridSize(),2)) {
            
            //Determine the current player based on move count
            Player currentPlayer = (count % 2 == 0) ? player1 : player2;
            char playerSymbol = currentPlayer.getSymbol();

            //Prompt the current player to make a move
            if (currentPlayer.makeMove(board)) {
                continue; //Skip incrementing count for invalid moves
            }

            //Check if the current player has won the game
            if (board.checkForWin(playerSymbol)) {
                System.out.printf("%s wins!\n", currentPlayer.getSymbol());
                break;
            }

            //Increment count after valid move
            count++;
        }

        //If the maximum number of moves (N^2) is reached without a winner
        if (count == Math.pow(board.getGridSize(),2)) {
            System.out.println("Draw!");
        }

        //Handle the end-of-game sequence
        endOfGame();
    }

    //Handles end-of-game options (restart or exit)
    private void endOfGame() {
        
        board.resetBoard(); //Reset board for potential new game

        System.out.println("Would you like to restart? (Type 'Yes' or 'No')");
       
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        String userResponse = userInput.toLowerCase();

        //Handle user's choice to restart or exit the game
        switch (userResponse) {
            //If yes, restart the game
            case "yes":
                startGameLoop();
                break;
            //If no, print exit message and exit program
            case "no":
                System.out.println("Thanks for playing!");
                System.exit(0);
                break;
            //Retry input if invalid
            default:
                System.out.println("Error: Bad input. Please type 'Yes' or 'No'.");
                endOfGame();
                break;
        }
    }

    //Main method to run the game
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //Display welcome message and game rules
        System.out.println("Welcome to Tic-Tac-Toe!\n");
        System.out.println("Rules:");
        System.out.println("Tic-Tac-Toe is a two-player game played on a 3x3 grid where players take turns marking a cell with their symbol (X or O).");
        System.out.println("The objective is to get three of your symbols in a row, column, or diagonal while preventing your opponent from doing the same.\n");
        
        //Prompt user to select the game mode
        System.out.println("Select Game Mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Computer vs Computer");

        int game_mode_choice = 0; //Variable to store user's game mode choice
        int grid_size_choice = 0; //Variable to store user's grid size choice
        boolean isValidChoice = false; //Flag to ensure valid input for choices

        //Validate user input for selecting the game mode
        while (!isValidChoice) {
            try {
                System.out.println("Enter your choice (1, 2, or 3):");
                game_mode_choice = sc.nextInt();
                if (game_mode_choice >= 1 && game_mode_choice <= 3) {
                    isValidChoice = true; //Input is valid
                } else {
                    System.out.println("Error: Please enter 1, 2, or 3");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid integer.");
                sc.next(); //Clear invalid input
            }
        } 

        //Set flag back to false to validate user's grid size choice
        isValidChoice = false;

        //Validate user input for selecting the grid size
        while (!isValidChoice) {
            try {
                System.out.println("Enter your choice for the size of the board (3 <= N <= 20):");
                grid_size_choice = sc.nextInt();
                //Chosen grid size must be between 3 and 20 inclusive
                if (grid_size_choice >= 3 && grid_size_choice <= 20) {
                    isValidChoice = true;
                } else {
                    System.out.println("Error: Please enter a valid board size (3 <= N <= 20)");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid integer.");
                sc.next();
            }
        } 

        Player player1 = null;
        Player player2 = null;

        //Create players based on the chosen game mode
        if (game_mode_choice == 1) {
            player1 = new HumanPlayer('X'); //Human player 'X'
            player2 = new HumanPlayer('O'); //Human player 'O'
        } else if (game_mode_choice == 2) {
            player1 = new HumanPlayer('X');    //Human player 'X'
            player2 = new ComputerPlayer('O'); //Computer player 'O'
        } else if (game_mode_choice == 3) {
            player1 = new ComputerPlayer('X'); //Computer player 'X'
            player2 = new ComputerPlayer('O'); //Computer player 'O'
        }

        //Create and start the game loop with the NxN board chosen by the user
        Game game = new Game(grid_size_choice, player1, player2);
        game.startGameLoop();

        //Close the scanner
        sc.close();
    }

}