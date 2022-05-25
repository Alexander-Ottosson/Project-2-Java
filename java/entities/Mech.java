package entities;

import enums.PILOTS;

public class Mech {
    private int mechId;
    private String make;
    private String model;
    private int year;
    private String color;
    private Double maxSpeed;
    private Double weight;
    private Double height;
    private String description;
    private PILOTS requiredPilots;
    private Boolean available;


    public Mech() {
        super();
    }
    public Mech(int mechId, String make, String model, int year, String color, Double maxSpeed, Double weight,
                Double height, String description, PILOTS requiredPilots, Boolean available) {
            this.mechId = mechId;
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.maxSpeed = maxSpeed;
            this.weight = weight;
            this.height = height;
            this.description = description;
            this.requiredPilots = requiredPilots;
            this.available = available;


    }
    public int getMechId() {
        return mechId;
    }
    public void setMechId(int mechId) {
        this.mechId = mechId;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Double getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.make = make;
    }
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public PILOTS getRequiredPilots() {
        return requiredPilots;
    }
    public void setRequiredPilots(PILOTS requiredPilots) {

        this.requiredPilots = requiredPilots;
    }

    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
