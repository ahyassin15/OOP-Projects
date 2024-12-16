package yassia8Q3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        //Call getUserNum() method to get user input and store it in variable 'num' of int data type
        int num = getUserNum();
        //Call trianglePattern() method to print right-angle triangle pattern
        trianglePattern(num);
    }

    //Method to get a valid user input
    private static int getUserNum() {
        
        //Create the Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        //Initialize the userNum variable and set it to zero
        int userNum = 0;
    
        //Loop until the user input entered is between 1 and 200
        while (userNum < 1 || userNum > 200) {
    
            System.out.print("Enter a number between 1 and 200: ");
                
            try {
                //Try to read the user input as int data type
                userNum = sc.nextInt();
                
                //Check if user input is valid, if it is not, then print out an error message
                if (userNum < 1 || userNum > 200) {
                    System.out.println("Invalid user input. Enter a number between 1 and 200.");
                }
    
            } catch (InputMismatchException e) {
                
                //Catch the invalid user input and prompt the user to enter a valid number
                System.out.println("Invalid user input. Please enter a valid numeric value.");
                //Clear the invalid input
                sc.next();
            }
        }
        //Return the valid user input
        return userNum;
    }

    //Method to print the right-angle triangle pattern
    private static void trianglePattern(int n) {
    
        //Outer for loop for each row (from 1st row to n row)
        for (int i = 1; i <= n; i++) {
            
            //Inner for loop to print numbers (from 1 to the current row number)
            for (int j = 1; j <= i; j++) {
                //Print the current number in the row
                System.out.print(j);
            }
               
            //Move to the next line after printing the numbers in the current row
            System.out.println();
        }
    }
}