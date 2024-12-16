package yassia8Q2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        
        //Call getUserNum() method to get user input and store it in variable 'num' of int data type
        int num = getUserNum();
        //Call divisibleNums() method to check and print the divisibility of numbers
        divisibleNums(num);
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

    //Method to check and print the results of numbers that are divisible by 3, 5, or both
    private static void divisibleNums(int n) {
          
        System.out.println("Numbers divisible by 3 or 5 or both:");
  
        //For loop from 1 to n, checking each number for divisibility by 3, 5, or both
        for (int i = 1; i <= n; i++) {
            
            //If the number is divisible by both 3 and 5, print the message for both
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " is divisible by both 3 and 5");
            
            //If the number is divisible by 3 only, print the message for 3
            } else if (i % 3 == 0) {
                System.out.println(i + " is divisible by 3");
            
            //If the number is divisible by 5 only, print the message for 5
            } else if (i % 5 == 0) {
                System.out.println(i + " is divisible by 5");
            }
        }
    }
  
}