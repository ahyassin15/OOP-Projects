package yassia8Q1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class OctalConversion {
    public static void main(String[] args) {
        
        //Call getUserDecimal() method to get user input and store it in variable 'decimalNum' of int data type
        int decimalNum = getUserDecimal();
        //Call convertToOctal() method to convert the decimalNum to octal
        int octalNum = convertToOctal(decimalNum);
        
        System.out.println("The octal number of " + decimalNum + " is " + octalNum);
    }

    //Method to get a valid decimal number between -1000 and 1000 from the user's input
    private static int getUserDecimal() {
        
        //Create the Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        //Initialize the decimal variable and set it out of the range between -1000 and 1000
        int decimal = 10000;
        
        //Loop until the user input entered is between -1000 and 1000
        while (decimal < -1000 || decimal > 1000) {

            System.out.print("Enter a decimal number between -1000 and 1000: ");
            
            try {
                //Try to read the user input as int data type
                decimal = sc.nextInt();
                
                //Check if user input is valid, if it is not, then print out an error message
                if (decimal < -1000 || decimal > 1000) {
                    System.out.println("Invalid input for decimal number. It should be between -1000 and 1000.");
                }

            } catch (InputMismatchException e) {
                
                //Catch the invalid user input and prompt the user to enter a valid number
                System.out.println("Invalid input for decimal number. Please enter a valid numeric value.");
                //Clear the invalid input
                sc.next();
            }
        }
        
        //Return the valid user input
        return decimal;
    }

    //Method to convert a decimal number to an octal number
    private static int convertToOctal(int decimal) {
        
        //Initialize octal variable to store the octal equivalent of the decimal number
        int octal = 0;
        
        //Initialize countVal variable to manage place values for the octal number
        int countVal = 1;

        //Initialize sign variable of type boolean to track if the original decimal was negative
        boolean sign = false;     
            
        //Check if the decimal is negative
        if (decimal < 0) {
            //Set sign to true
            sign = true;
            //Convert decimal variable to its absolute value
            decimal = Math.abs(decimal);
        }
        
        //Loop to convert decimal to octal
        while (decimal > 0) { 
            //Calculate the remainder when the decimal is divided by 8 (octal base)
            int remainder = decimal % 8;
            //Build octal number by adding the remainder multiplied by countVal
            octal += remainder * countVal;
            //Update countVal to the next place value
            countVal *= 10;
            //Reduce the decimal number by dividing it by 8
            decimal /= 8;
        }

        //If the original decimal was negative, convert the octal result to negative
        if (sign) {
            octal = -octal;
        }

        //Return octal value
        return octal;
    }
}
