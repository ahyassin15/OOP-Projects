package yassia8Q2;

public class ElectricCar extends Car {
    
    //Attributes specific to gasoline-powered cars
    private double batteryCapacity;
    private double miles_per_kwh;

    //ElectricCar constructor to initialize make, model, battery capacity, and battery efficiency
    public ElectricCar(String make, String model, double batteryCapacity, double miles_per_kwh) {
        super(make, model);
        this.batteryCapacity = batteryCapacity;
        this.miles_per_kwh = miles_per_kwh;
    }

    @Override //@Override denotes that the subclass method overrides the parent class method (implements polymorphism and inheritance)
    //Returns fuel efficiency in miles per kWh
    public double calculateFuelEfficiency() {
        return miles_per_kwh;
    }

    @Override
    //Returns range in miles
    public double calculateRange() {
        return batteryCapacity * miles_per_kwh;
    }

    //Get battery capacity
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    //Get miles per kWh
    public double getMilesPerKilowattHour() {
        return miles_per_kwh;
    }

}