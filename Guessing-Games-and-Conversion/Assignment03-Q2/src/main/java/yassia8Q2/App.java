package yassia8Q2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        //Create scanner object to get user input
        Scanner sc = new Scanner(System.in);

        //Provide prompt to get user input for a telephone number in the format: XXX-XXX-XXXX
        System.out.print("Enter a 10-character telephone number (XXX-XXX-XXXX): ");
        String phoneNum = sc.nextLine();

        //Validate the input format
        if (validFormatCheck(phoneNum)) {
            
            //Convert the phone number to its numeric equivalent
            String numericPhoneNum = convertToNumeric(phoneNum);

            //Output the result of the numeric phone number
            System.out.println("Numeric Telephone Number: " + numericPhoneNum);

        } else {
            
            //Catch the invalid user input and prompt the user to enter a valid phone number
            System.out.println("Invalid input. Please enter the phone number in the correct format (XXX-XXX-XXXX).");

        }
    
        //Close the scanner
        sc.close();

    }

    private static int getNumFromLetter(char letter) {

        //Convert input character to uppercase using the .toUpperCase() method from the Character class to make it case-insensitive
        letter = Character.toUpperCase(letter);

        //If letter is between A and C, return 2 as they map to 2
        if (letter >= 'A' && letter <= 'C') {
            return 2;
        
        //If letter is between D and F, return 3 as they map to 3
        } else if (letter >= 'D' && letter <= 'F') {
            return 3;

        //If letter is between G and I, return 4 as they map to 4
        } else if (letter >= 'G' && letter <= 'I') {
            return 4;
        
        //If letter is between J and L, return 5 as they map to 5
        } else if (letter >= 'J' && letter <= 'L') {
            return 5;
        
        //If letter is between M and O, return 6 as they map to 6
        } else if (letter >= 'M' && letter <= 'O') {
            return 6;

        //If letter is between P and S, return 7 as they map to 7
        } else if (letter >= 'P' && letter <= 'S') {
            return 7;

        //If letter is between T and V, return 8 as they map to 8
        } else if (letter >= 'T' && letter <= 'V') {
            return 8;

        //If letter is between W and Z, return 9 as they map to 9
        } else if (letter >= 'W' && letter <= 'Z') {
            return 9;

        //If the character is not a letter from A-Z
        } else {
            //return -1 to indicate the input is invalid
            return -1;
        }
    }

    private static String convertToNumeric(String phoneNum) {
        //Make object of StringBuilder class to make the string mutable and convert the phone number from letters into numbers
        //StringBuilder class enables strings to be mutable
        StringBuilder numericPhoneNum = new StringBuilder();

        //For each character in the phoneNum string
        for (int i=0; i < phoneNum.length(); i++) {
            //Get current character at index i
            char currentChar = phoneNum.charAt(i);

            //Check if the current character is a letter using the isLetter() method in the Character class
            if (Character.isLetter(currentChar)) {
                //Convert letter to uppercase for case-insensitivity, find its corresponding numeric value and append it to the result
                numericPhoneNum.append(getNumFromLetter(Character.toUpperCase(currentChar)));
            } else {
                //If the current character isn't a letter, then append it with no conversion
                numericPhoneNum.append(currentChar);
            }
        }

        //Convert StringBuilder object (numericPhoneNum) into a string and return it
        return numericPhoneNum.toString();
    }

    private static boolean validFormatCheck(String phoneNum) {
        //Check if the phone number is 12 characters long and there are hyphens at the 3rd and 7th indexes
        return (phoneNum.length() == 12) && (phoneNum.charAt(3) == '-') && (phoneNum.charAt(7) == '-');
    }
}