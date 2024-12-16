package yassia8Q3;

public class ElectricCar extends Car implements Refuel {
    
    //Attributes specific to electric-powered cars
    private double batteryCapacity;
    private double miles_per_kwh;
    private double currentChargeLevel;

    //ElectricCar constructor to initialize make, model, battery capacity, and battery efficiency
    public ElectricCar(String make, String model, double batteryCapacity, double miles_per_kwh, double currentChargeLevel) {
        super(make, model);
        this.batteryCapacity = batteryCapacity;
        this.miles_per_kwh = miles_per_kwh;
        this.currentChargeLevel = currentChargeLevel;
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

    //Get current charge level
    public double getCurrentChargeLevel() {
        return currentChargeLevel;
    }

    @Override
    //Add charge to the electric car
    public void addEnergy(double amount) {
        //If the current fuel level and added amount exceed the fuel capacity
        if (currentChargeLevel + amount > batteryCapacity) {
            //Cap it at maximum capacity
            currentChargeLevel = batteryCapacity;
        
        //If less than full capacity
        } else {
            //Add amount to current fuel level
            currentChargeLevel += amount;
        }
        //Print updated fuel level
        System.out.println("Added " + amount + " kWh of charge.\nCurrent charge level: " + currentChargeLevel + " kWh\n");
    }
}