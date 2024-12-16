package yassia8Q5;

import java.util.ArrayList;
import java.util.List;

public class FleetManager {

    public static void main(String[] args) {

        //Create a list to store Car objects that extend Car class
        List<Car> fleet = new ArrayList<>();

        //Add cars to the fleet
        fleet.add(new GasolineCar("Audi", "Q5", 18.5, 25.0, 10.0));
        fleet.add(new ElectricCar("Tesla", "Model 3", 75.0, 4.5, 50.0));
        fleet.add(new HybridCar("Toyota", "Prius", 11.0, 57.0, 13.5, 3.0, true));  //Hybrid with both gas and electric features
        fleet.add(new HybridCar("Ford", "Fusion", 14.0, 42.0, 7.0));  //Hybrid with only gasoline features and no electric features

        //Print out details of car fleet
        System.out.println("Fleet Details:");
        //For each car in fleet
        for (Car car : fleet) {
            System.out.println("Car Make: " + car.getMake() + ", Car Model: " + car.getModel());  //Print make and model
            System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency());              //Print fuel efficiency
            System.out.println("Range: " + car.calculateRange() + " miles");                      //Print range
            System.out.println();
        }

        //Initialize total_range to zero
        double total_range = 0;

        //For each car in fleet
        for (Car car : fleet) {
            //Add the current car's range to the total range
            total_range += car.calculateRange();
        }

        System.out.println("Total Fleet Range: " + total_range + " miles");
    }
}
