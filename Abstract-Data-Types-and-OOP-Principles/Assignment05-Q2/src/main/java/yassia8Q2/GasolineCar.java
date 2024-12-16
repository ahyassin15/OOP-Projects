package yassia8Q2;

public class GasolineCar extends Car {
    
    //Attributes specific to gasoline-powered cars
    private double fuelTankCapacity;
    private double milesPerGallon;

    //GasolineCar constructor to initialize make, model, fuel tank capacity, and fuel efficiency
    public GasolineCar(String make, String model, double fuelTankCapacity, double milesPerGallon) {
        super(make, model);
        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
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
}
