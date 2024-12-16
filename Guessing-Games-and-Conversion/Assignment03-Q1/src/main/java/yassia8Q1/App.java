package yassia8Q1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {

        //Create scanner object to get all user inputs
        Scanner sc = new Scanner(System.in);
        
        //Provide prompt to get user input values of coefficients a,b,c using gertCoefficient() method
        //Store these input values into variables of 'double' type
        double coeff_a = getCoefficient("a", sc);
        double coeff_b = getCoefficient("b", sc);
        double coeff_c = getCoefficient("c", sc);
        
        //Call solveQuadraticEqn() method to solve the quadratic equation using coefficients a,b,c
        String quadratic_result = solveQuadraticEqn(coeff_a, coeff_b, coeff_c);
        
        //Print the quadratic equation's result
        System.out.println(quadratic_result);

        //Close the scanner
        sc.close();

    }

    private static String solveQuadraticEqn(double a, double b, double c) {
        
        //Check if coefficient 'a' is zero, if it is, print error message as it would divide the quadratic formula by zero
        if (a == 0) {
            return "Error: The coefficient 'a' cannot be zero in a quadratic equation.";
        }

        //Calculate the discriminant of the quadratic (b^2 - 4ac)
        double discriminant = (b*b) - (4*a*c);

        //Check number of real roots with the quadratic formula and discriminant value (root = (-b +- sqrt(discriminant)) / (2*a))  
        if (discriminant > 0) {
            //If the discriminant is greater than 0, there are two distinct real roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2*a);
            return String.format("The roots are %.2f and %.2f", root1, root2);
        
        } else if (discriminant == 0) {
            //If the discriminant is 0, there is one real root
            double root = (-b) / (2*a);
            return String.format("The root is %.2f", root);
        
        } else {
            //If the discriminant is negative, there are no real roots
            return "The quadratic equation has no real roots";
        }

    }

    private static double getCoefficient(String coeff_name, Scanner scanner) {

        //Initialize coefficient variable and set it out of the range between -100 and 100
        double coefficient = 1000;

        //Loop until the user input entered is between -100 and 100
        while (coefficient < -100 || coefficient > 100) {

            System.out.print("Enter the value of coefficient '" + coeff_name + "' between -100 and 100: ");
            
            try {
                //Try to read the user input as double data type
                coefficient = scanner.nextDouble();
                
                //Check if user input is valid, if it is not, then print out an error message
                if (coefficient < -100 || coefficient > 100) {
                    System.out.println("Invalid input for coefficient '" + coeff_name + "'. It should be between -100 and 100.");
                }

            } catch (InputMismatchException e) {
                
                //Catch the invalid user input and prompt the user to enter a valid number
                System.out.println("Invalid input for coefficient. Please enter a valid numeric value.");
                //Clear the invalid input
                scanner.next();
            }
        }

        //Return the valid user input of coefficient 'a'
        return coefficient;
    }
}