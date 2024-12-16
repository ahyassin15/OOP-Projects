package yassia8Q6;

public class HybridCar extends Car {

    //Attributes of both gasoline and electric features for hybrid car
    private double fuelTankCapacity;
    private double milesPerGallon;
    private double currentFuelLevel;
    private double batteryCapacity;
    private double miles_per_kwh;
    private double currentChargeLevel;

    //Constructor 1 - Initialize with only gasoline features and no electric features
    public HybridCar(String make, String model, double fuelTankCapacity, double milesPerGallon, double currentFuelLevel) {
        super(make, model);

        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
        this.currentFuelLevel = currentFuelLevel;

        this.batteryCapacity = 0;     //No battery
        this.currentChargeLevel = 0;  //No charge
        this.miles_per_kwh = 0;       //No battery efficiency
    }

    //Constructor 2 - Initialize with both gasoline and electric features
    public HybridCar(String make, String model, double fuelTankCapacity, double milesPerGallon, double currentFuelLevel, double batteryCapacity, double miles_per_kwh, double currentChargeLevel) {
        super(make, model);

        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
        this.currentFuelLevel = currentFuelLevel;

        this.batteryCapacity = batteryCapacity;
        this.miles_per_kwh = miles_per_kwh;
        this.currentChargeLevel = currentChargeLevel;
    }

    //Overloaded Constructor 3 - Initialize with fully charged battery and full fuel tank
    public HybridCar(String make, String model, double fuelTankCapacity, double milesPerGallon, double batteryCapacity, double miles_per_kwh, boolean fullyFueled) {
        this(make, model, fuelTankCapacity, milesPerGallon, 0, batteryCapacity, miles_per_kwh, 0);
        
        if (fullyFueled) {
            this.currentFuelLevel = fuelTankCapacity;  //Fully fill the fuel tank
            this.currentChargeLevel = batteryCapacity; //Fully charge the battery
        }
    }

    @Override
    public double calculateFuelEfficiency() {
        //Combine fuel efficiency and electric efficiency and return average
        return (milesPerGallon + miles_per_kwh) / 2.0;
    }

    @Override
    public double calculateRange() {
        //Calculate total range from both fuel and battery
        double fuelRange = currentFuelLevel * milesPerGallon;
        double electricRange = currentChargeLevel * miles_per_kwh;

        return fuelRange + electricRange;
    }

    //Add fuel to the car
    public void addFuel(double gallons) {
        //If the current fuel level and added gallons exceed the fuel capacity
        if (currentFuelLevel + gallons > fuelTankCapacity) {
            //Cap it at maximum capacity
            currentFuelLevel = fuelTankCapacity;

        //If less than full capacity
        } else {
            //Add gallons to current fuel level
            currentFuelLevel += gallons;
        }
        System.out.println("Added " + gallons + " gallons of fuel.\nCurrent fuel level: " + currentFuelLevel + " gallons");
    }

    //Charge the car
    public void addCharge(double kWh) {
        //If the current charge level and added kilowatt hours exceed the battery capacity
        if (currentChargeLevel + kWh > batteryCapacity) {
            //Cap at maximum capacity
            currentChargeLevel = batteryCapacity;

        //If less than full capacity
        } else {
            //Add kWh to current fuel level
            currentChargeLevel += kWh;
        }
        System.out.println("Added " + kWh + " kWh of charge.\nCurrent charge level: " + currentChargeLevel + " kWh");
    }
}
