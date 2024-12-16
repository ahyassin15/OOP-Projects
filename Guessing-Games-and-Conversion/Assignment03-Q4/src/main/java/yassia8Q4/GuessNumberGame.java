package yassia8Q4;

import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame {
    
    //Initialize max_trials variable for the maximum number of allowed attempts (10) for the game
    private static final int max_trials = 10;
    //Initialize trials_used variable to track how many guess attempts the user has made
    private int trials_used;
    //Initialize target_number variable for the randomly generated number that needs to be guessed by the user
    private int target_number;

    //Create constructor to initialize the game with a random target number
    public GuessNumberGame() {

        //Create random object to be used to randomly generate the target_number
        Random random = new Random();

        //Random target number in the range from -100 to 100
        this.target_number = random.nextInt(201) - 100;

        //Set trials_used to zero
        this.trials_used = 0;
    }

    public void startGame() {
        
        //Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        //Initialize user_guess variable of int type to store the user's number
        int user_guess;
        //Initialize isGuessed variable of boolean type to track if the target number has been guessed
        boolean isGuessed = false;

        //Loop until the user guesses the target number correctly or uses all their allowed trials 
        while (trials_used < max_trials && !isGuessed) {
            
            System.out.print("Enter your guess between -100 and 100: ");
            
            //Get user's input for their guess
            user_guess = sc.nextInt();
            //Increment number of trials used by 1 after every guess
            trials_used++;
            //Check user's guess if it correct or not
            isGuessed = checkGuess(user_guess);
        }

        //If the user did not guess the number correctly after all 10 trials
        if (!isGuessed) {
            //Output the target number and inform them that they used up all of their attempts
            System.out.println("You have exhausted your trials. The correct number was: " + target_number);
        }
        
        //Close the scanner
        sc.close();
    }

    private boolean checkGuess(int guess) {

        //If the user's guess is greater than the target number
        if (guess > target_number) {
            
            //Reveal hint
            System.out.println("The target number is lower than " + guess + ".");      
            //Return false as the guess is incorrect
            return false;

        //If the user's guess is less than the target number
        } else if (guess < target_number) {
            
            //Reveal hint 
            System.out.println("The target number is higher than " + guess + ".");
            //Return false as the guess is incorrect
            return false;

        //If the user's guess is equal to the target number
        } else {

            //Print they guessed the number correctly
            System.out.println("You successfully guessed the target number!");
            //Return true as the guess is correct
            return true;
        }
    }

    public static void main(String[] args) {

        //Create an instance of the game
        GuessNumberGame game = new GuessNumberGame();

        //Start the game
        game.startGame();
    }
}
