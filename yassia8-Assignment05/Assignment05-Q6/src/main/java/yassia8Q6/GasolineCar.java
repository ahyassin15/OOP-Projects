package yassia8Q6;

public class GasolineCar extends Car implements Refuel {
    
    //Attributes specific to gasoline-powered cars
    private double fuelTankCapacity;
    private double milesPerGallon;
    private double currentFuelLevel;

    //GasolineCar constructor to initialize make, model, fuel tank capacity, and fuel efficiency
    public GasolineCar(String make, String model, double fuelTankCapacity, double milesPerGallon, double currentFuelLevel) {
        super(make, model);
        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
        this.currentFuelLevel = currentFuelLevel;
    }
    
    @Override //@Override denotes that the subclass method overrides the parent class method (implements polymorphism and inheritance)
    //Returns fuel efficiency in miles per gallon
    public double calculateFuelEfficiency() {
        return milesPerGallon;
    }
    
    @Override
    //Returns range in miles
    public double calculateRange() {
        return fuelTankCapacity * milesPerGallon;
    }

    //Get fuel tank capacity
    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    //Get miles per gallon
    public double getMilesPerGallon() {
        return milesPerGallon;
    }

    //Get current fuel level
    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    @Override
    //Add fuel to the gasoline-powered car
    public void addEnergy(double amount) {
        //If the current fuel level and added amount exceed the fuel capacity
        if (currentFuelLevel + amount > fuelTankCapacity) {
            //Cap it at maximum capacity
            currentFuelLevel = fuelTankCapacity;
        
        //If less than full capacity
        } else {
            //Add amount to current fuel level
            currentFuelLevel += amount;
        }
        //Print updated fuel level
        System.out.println("Added " + amount + " gallons of fuel.\nCurrent fuel level: " + currentFuelLevel + " gallons\n");
    }

}
