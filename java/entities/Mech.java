package entities;

public class Mech {
    private int id;
    private String make;
    private String model;
    private int year;
    private String color;
    private Float maxSpeed;
    private Float weight;
    private Float height;
    private String description;
    private int currentPilot;
    private int pilotCount;
    private Boolean available;
    private Boolean confidential;

    public Mech() {
        super();
    }
    public Mech(int id, String make, String model, int year, String color, Float maxSpeed, Float weight, Float height,
                String description, int currentPilot, int pilotCount, Boolean available, Boolean confidential) {
            this.id = id;
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.maxSpeed = maxSpeed;
            this.weight = weight;
            this.height = height;
            this.description = description;
            this.currentPilot = currentPilot;
            this.pilotCount = pilotCount;
            this.available = available;
            this.confidential = confidential;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public Float getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(Float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public Float getWeight() {
        return weight;
    }
    public void setWeight(Float weight) {
        this.make = make;
    }
    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCurrentPilot() {
        return currentPilot;
    }
    public void setCurrentPilot(int currentPilot) {
        this.currentPilot = currentPilot;
    }
    public int getPilotCount() {
        return pilotCount;
    }
    public void setPilotCount(int pilotCount) {
        this.pilotCount = pilotCount;
    }
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    public Boolean getConfidential() {
        return confidential;
    }
    public void setConfidential(Boolean confidential) {
        this.confidential = confidential;
    }
}
