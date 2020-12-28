package SimiAlex.com.github.AutoStoreJavaEE.entities;

public class Car 
{
    //fields
    private int id;
    private String model;
    private String make;
    private int year;
    private int price;
    private String fuelType;
    private String bodyType;
    private int milage;
    private static int lastId = 0;

    //constructor
    public Car()
    {
        id = ++lastId;
    }
    
    //methods
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }    

    @Override
    public String toString()
    {
        return make + " " + model + " (" + year + ")";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Car.lastId = lastId;
    }
}
