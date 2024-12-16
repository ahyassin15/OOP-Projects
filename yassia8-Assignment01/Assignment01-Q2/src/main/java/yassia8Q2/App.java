package yassia8Q2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    
    public static void main(String[] args) {
        
        //Create the Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        //Initialize the radius variable and set it to zero 
        double radius = 0;

        //Loop until the radius input entered is between 0.0 and 10.0
        while (radius <= 0.0 || radius > 10.0) {
            
            System.out.println("Enter the radius of the circle (0.0 < radius <= 10.0):");

            try {
                //Try to read the radius input as double data type
                radius = sc.nextDouble();
                
                //Check if radius input is valid, if it is not, then print out an error message
                if (radius <= 0.0 || radius > 10.0) {
                    System.out.println("Invalid input for radius. The radius must be between 0.0 and 10.0.");
                }
                
            } catch (InputMismatchException e) {
                //Catch the invalid radius input and prompt the user to enter a valid number
                System.out.println("Invalid input for radius. Please enter a valid numeric value.");
                //Clear the invalid input
                sc.next();
            }
        }

        //Calculate the area and perimeter of the circle using the radius input
        double area = Math.PI * Math.pow(radius, 2);
        double perimeter = 2 * Math.PI * radius;

        //Print out the calculated area and perimeter
        System.out.printf("Area: %.2f%n", area);
        System.out.printf("Perimeter: %.2f%n", perimeter);

        //Close the Scanner
        sc.close();
    }
}