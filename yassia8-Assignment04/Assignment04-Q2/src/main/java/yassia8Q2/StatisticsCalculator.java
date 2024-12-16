package yassia8Q2;

import java.text.DecimalFormat;
import java.util.Arrays;

public class StatisticsCalculator {
    
    public static void main(String[] args) {
        try {
            // Initialize StatisticsCalculator with an array
            int[] data = {5, 3, 8, 6, 2};
            StatisticsCalculator calculator = new StatisticsCalculator(data);

            //Calculate and print average
            System.out.println("Average: " + calculator.calculateAvg());

            //Calculate and print median
            System.out.println("Median: " + calculator.calculateMedian());

            //Update array
            int[] newData = {10, 20, 30, 40, 50, 60, 70, 80};
            calculator.updateArr(newData);
            System.out.println("Updated Average: " + calculator.calculateAvg());
            System.out.println("Updated Median: " + calculator.calculateMedian());

            //Access the array safely
            int[] arrayCopy = calculator.getArray();
            System.out.println("Array Copy: " + Arrays.toString(arrayCopy));
        
        //If invalid array, catch and print error message
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Store the integer array for calculations
    private int[] data;
    //Formats double values to two decimal places
    private final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    //Constructor
    public StatisticsCalculator(int[] data) {
        updateArr(data); // Using updateArr method to validate data during initialization
    }

    //Calculates average of the elements in the data array
    public double calculateAvg() {
        
        //Check if the data array is empty, throw ArithmeticException if it is
        if (data.length == 0) {
            throw new ArithmeticException("Array is empty. Cannot perform operation.");
        }

        //Initialize sum variable and set it to 0
        double sum = 0;

        //For every num in the array, add it to the sum
        for (int num : data) {
            sum += num;
        }
        
        //Calculate the average
        double average = sum / data.length;

        //Format average to two decimal places and return it
        return Double.parseDouble(decimalFormat.format(average));
    }

    //Calculates median of the elements in the data array
    public double calculateMedian() {

        //Check if the data array is empty, throw ArithmeticException if it is
        if (data.length == 0) {
            throw new ArithmeticException("Array is empty. Cannot perform operation.");
        }

        //Create copy of data array to avoid modifying the original
        int[] sortedData = Arrays.copyOf(data, data.length);
        //Sort copied array to find median
        Arrays.sort(sortedData);

        //Declares median variable
        double median;
        //Find middle index of sorted array
        int mid = sortedData.length / 2;

        //If the number of elements is even
        if (sortedData.length % 2 == 0) {
            //Calculate average of the two middle elements as the median
            median = (sortedData[mid - 1] + sortedData[mid]) / 2.0;
        } else {
            //If the number of elements is odd, use middle element as the median 
            median = sortedData[mid];
        }

        //Format median to two decimal places and return it
        return Double.parseDouble(decimalFormat.format(median));
    }

    //Updates the data array with a new set of integers
    public void updateArr(int[] newData) {

        //Validate that newData array is not null or empty
        if (newData == null || newData.length == 0) {
            throw new IllegalArgumentException("Invalid input. Array cannot be null or empty.");
        }
        
        //Update data with a copy of newData
        this.data = Arrays.copyOf(newData, newData.length);
    }

    //Returns a copy of the current data array
    public int[] getArray() {
        return Arrays.copyOf(data, data.length);
    }

}
