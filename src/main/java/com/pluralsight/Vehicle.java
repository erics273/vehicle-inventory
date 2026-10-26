package com.pluralsight;

public class Vehicle {

    /*
    create these properties:

    vehicleId - a long (ex: 101121)
    makeModel - a string (ex: Ford Explorer)
    color - a string (ex: Red)
    odometerReading - an int (ex: 32775)
    price - a double (ex: 12250.00) (no Lamborghinis here!)
     */
    private long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private double price;


    //Add a constructor and get/set methods for each property of the car.


    public Vehicle(long vehicleId, String makeModel, String color, int odometerReading, double price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
