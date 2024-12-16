package yassia8Q6;

//Abstract class named Car
public abstract class Car {

    //Attributes to represent the make and model of car
    private String make;
    private String model;
    
    //Car constructor to initialize the make and model of car
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    //Return make of car
    public String getMake() {
        return make;
    }

    //Return model of car
    public String getModel() {
        return model;
    }

    //Abstract method to calculate fuel efficiency and range
    public abstract double calculateFuelEfficiency();
    public abstract double calculateRange();
    
}
