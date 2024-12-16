package yassia8Q4;

import java.util.ArrayList;
import java.util.List;

public class FleetManager {

    //Method to iterate over car fleet and print fuel efficiency and range of each car
    public static void printCarDetails(List<Car> fleet) {

        //For each car in fleet
        for (Car car : fleet) {
            System.out.println("Car Make: " + car.getMake() + ", Car Model: " + car.getModel()); //Print make and model
            System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " (mpg or mpkWh)"); //Print fuel efficiency
            System.out.println("Range: " + car.calculateRange() + " miles"); //Print range
            System.out.println(); //Print new line
        }
    }

    //Method to calculate total range of all cars in fleet
    public static double calculateTotalRange(List<Car> fleet) {
        
        //Initialize total_range to zero
        double total_range = 0;

        //For each car in fleet
        for (Car car : fleet) {
            //Add the current car's range to the total range
            total_range += car.calculateRange();
        }
        //Return total range
        return total_range;
    }

    public static void main(String[] args) {

        //Create a list of Car objects (aka the car fleet)
        List<Car> fleet = new ArrayList<>();

        //Add GasolineCar and ElectricCar instances to the fleet
        GasolineCar gasolineCar1 = new GasolineCar("Honda", "CR-V", 14.0, 30.0, 10.0); //14 gallons, 30 mpg
        GasolineCar gasolineCar2 = new GasolineCar("BMW", "X6", 22.0, 25.0, 1.5);      //21.9 gallons, 25 mpg
        GasolineCar gasolineCar3 = new GasolineCar("Lexus", "NX350", 14.5, 26.0, 4.5);      //14.5 gallons, 26 mpg
        ElectricCar electricCar1 = new ElectricCar("Tesla", "Cybertruck", 123.0, 2.5, 50.0); //123 kWh, 2.5 miles/kWh
        ElectricCar electricCar2 = new ElectricCar("Nissan", "Leaf", 40.0, 3.5, 35.0);   //40 kWh, 3.5 miles/kWh
        ElectricCar electricCar3 = new ElectricCar("BMW", "iX", 111.5, 3.0, 25.0);   //111.5 kWh, 3.0 miles/kWh

        //Add cars to fleet
        fleet.add(gasolineCar1); 
        fleet.add(gasolineCar2); 
        fleet.add(gasolineCar3);
        fleet.add(electricCar1); 
        fleet.add(electricCar2); 
        fleet.add(electricCar3);

        //Add energy to cars (gallons or kWh)
        gasolineCar1.addEnergy(5.0); 
        gasolineCar2.addEnergy(20.0);
        gasolineCar3.addEnergy(10.0); 
        electricCar1.addEnergy(33.0); 
        electricCar2.addEnergy(10.0);
        electricCar3.addEnergy(47.5); 

        //Print details of each car in fleet
        System.out.println("Fleet Details:");
        printCarDetails(fleet);

        //Calculate total range of fleet and print it
        double total_range = calculateTotalRange(fleet);
        System.out.println("Total Fleet Range: " + total_range + " miles");
    }
}

