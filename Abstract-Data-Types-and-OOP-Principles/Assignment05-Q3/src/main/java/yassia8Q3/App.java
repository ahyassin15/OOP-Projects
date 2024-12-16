package yassia8Q3;

public class App {
    public static void main(String[] args) {

        //Create GasolineCar object using Refuelable interface reference
        Refuel gasolineCar = new GasolineCar("BMW", "X6", 22.0, 25.0, 10.0);

        //Create ElectricCar object using Refuelable interface reference
        Refuel electricCar = new ElectricCar("Tesla", "Cybertruck", 123.0, 2.5, 55.0);

        //Add energy to gasoline car (12.3 gallons of fuel)
        gasolineCar.addEnergy(12.3);

        //Add energy to electric car (40 kWh of charge)
        electricCar.addEnergy(40.0);
    }
}