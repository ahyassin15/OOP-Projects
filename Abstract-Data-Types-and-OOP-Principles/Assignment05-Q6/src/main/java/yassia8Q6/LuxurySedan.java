package yassia8Q6;

public class LuxurySedan extends LuxuryCar {

    //Attributes specific to the luxury sedan
    private double fuelTankCapacity;  
    private double milesPerGallon;    
    private double currentFuelLevel;  

    //Constructor to initialize luxury sedan features
    public LuxurySedan(String make, String model, boolean hasPremiumSpeakerSystem, boolean hasMassagingSeats, boolean hasInteriorLights, boolean hasTVSystem, double fuelTankCapacity, double milesPerGallon, double currentFuelLevel) {
        super(make, model, hasPremiumSpeakerSystem, hasMassagingSeats, hasInteriorLights, hasTVSystem);
        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
        this.currentFuelLevel = currentFuelLevel; // Ensure level is within capacity
    }

    @Override
    //Calculate fuel efficiency in miles per gallon
    public double calculateFuelEfficiency() {
        return milesPerGallon;
    }

    @Override
    //Calculate range in miles
    public double calculateRange() {
        return currentFuelLevel * milesPerGallon;
    }

    //Add fuel to luxury sedan
    public void addFuel(double gallons) {
        //If the current fuel level and added amount exceed the fuel capacity
        if (currentFuelLevel + gallons > fuelTankCapacity) {
            //Cap it at maximum capacity
            currentFuelLevel = fuelTankCapacity;
        
        //If less than full capacity
        } else {
            //Add amount to current fuel level
            currentFuelLevel += gallons;
        }
        //Print updated fuel level
        System.out.println("Added " + gallons + " gallons of fuel.\nCurrent fuel level: " + currentFuelLevel + " gallons\n");
    }
    

    //Speaker system luxury feature
    public void activateSpeakerSystem() {
        if (hasPremiumSpeakerSystem()) {
            System.out.println("Premium speaker system activated.");
        } else {
            System.out.println("This car does not have a premium speaker system.");
        }
    }

    //Massaging seats luxury feature
    public void activateMassagingSeats() {
        if (hasMassagingSeats()) {
            System.out.println("Massaging seats activated.");
        } else {
            System.out.println("This car does not have massaging seats.");
        }
    }

    public void activateInteriorLights() {
        if (hasInteriorLights()) {
            System.out.println("Interior lights activated.");
        } else {
            System.out.println("This car does not have interior lights.");
        }
    }

    public void activateTVSystem() {
        if (hasTVSystem()) {
            System.out.println("TV system activated.");
        } else {
            System.out.println("This car does not have a TV system.");
        }
    }
}
