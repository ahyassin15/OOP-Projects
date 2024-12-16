package yassia8Q6;

//Abstract class for luxury cars
public abstract class LuxuryCar extends Car {
    
    //Attributes specific to luxury cars
    private boolean hasPremiumSpeakerSystem;
    private boolean hasMassagingSeats;
    private boolean hasInteriorLights;
    private boolean hasTVSystem;

    //Constructor to initialize luxury features
    public LuxuryCar(String make, String model, boolean hasPremiumSpeakerSystem, boolean hasMassagingSeats, boolean hasInteriorLights, boolean hasTVSystem) {
        super(make, model);
        this.hasPremiumSpeakerSystem = hasPremiumSpeakerSystem;
        this.hasMassagingSeats = hasMassagingSeats;
        this.hasInteriorLights = hasInteriorLights;
        this.hasTVSystem = hasTVSystem;
    }

    //Getter for premium speaker system
    public boolean hasPremiumSpeakerSystem() {
        return hasPremiumSpeakerSystem;
    }

    //Getter for massaging seats
    public boolean hasMassagingSeats() {
        return hasMassagingSeats;
    }

    //Getter for interior lights
    public boolean hasInteriorLights() {
        return hasInteriorLights;
    }

    //Getter for TV system
    public boolean hasTVSystem() {
        return hasTVSystem;
    }

    //Abstract methods inherited from Car
    @Override
    public abstract double calculateFuelEfficiency();
    @Override
    public abstract double calculateRange();
}
