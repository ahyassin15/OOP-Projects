package yassia8Q6;

import java.util.ArrayList;
import java.util.List;

public class FleetManager {

    public static void main(String[] args) {
        // Create a list of cars
        List<Car> fleet = new ArrayList<>();

        // Add various types of cars to the fleet
        fleet.add(new GasolineCar("Toyota", "Camry", 15.0, 30.0, 1.0)); //Gasoline car
        fleet.add(new ElectricCar("Tesla", "Model 3", 75.0, 4.0, 29.0)); //Electric car
        fleet.add(new HybridCar("Toyota", "Prius", 11.0, 57.0, 13.5, 3.0, true));  //Hybrid car
        fleet.add(new LuxurySedan("Rolls-Royce", "Phantom", true, true, true, false, 24.0, 18.0, 15.0)); //Luxury sedan

        // Print details of the fleet
        System.out.println("Fleet Details:");
        for (Car car : fleet) {
            System.out.println("Car Make: " + car.getMake() + ", Model: " + car.getModel());
            System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency());
            System.out.println("Range: " + car.calculateRange() + " miles");
            System.out.println();
        }

        
        //Retrieve car at index 3 from the fleet
        LuxurySedan luxurySedan = (LuxurySedan) fleet.get(3);
        
        //Display luxury features of the luxury sedan object (Rolls-Royce Phantom)
        luxurySedan.activateSpeakerSystem();
        luxurySedan.activateMassagingSeats();
        luxurySedan.activateInteriorLights();
        luxurySedan.activateTVSystem();

        //Calculate total range of fleet
        double total_range = fleet.stream().mapToDouble(Car::calculateRange).sum();
        System.out.println("Total Fleet Range: " + total_range + " miles");
    }
}
