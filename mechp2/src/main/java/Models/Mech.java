package Models;

import java.util.Objects;

public class Mech {
    private int mechId;
    private String make;
    private String model;
    private String year;
    private String color;
    private Double maxSpeed;
    private Double weight;
    private Double height;

    private String des;

    private int cp;

    private int pc;
    private Boolean ava;

    private Boolean con;


    public Mech() {
        super();
    }
    public Mech(int mechId, String make, String model, String year, String color, Double maxSpeed, Double weight,
                Double height, String des, int cp, int pc, Boolean ava, Boolean con) {
        this.mechId = mechId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.height = height;
        this.des = des;
        this.cp = cp;
        this.pc = pc;
        this.ava = ava;
        this.con = con;


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
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public Boolean getAva() {
        return ava;
    }

    public void setAva(Boolean ava) {
        this.ava = ava;
    }
    public Boolean getCon() {
        return con;
    }

    public void setCon(Boolean con) {
        this.con = con;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getMechId(), getMake(), getModel(), getYear(), getColor(), getMaxSpeed(), getWeight(),
                getHeight(), getDes(), getCp(), getPc(), getAva(), getCon());
    }

    @Override
    public String toString() {
        return "Models.Mech{" +
                "id=" + mechId +
                ", make=" + make +
                ", model=" + model +
                ", year=" + year +
                ", color=" + color +
                ", maxSpeed=" + maxSpeed +
                ", weight=" + weight +
                ", height=" + height +
                ", description=" + des +
                ", currentPilot=" + cp +
                ", pilotCount=" + pc +
                ", available=" + ava +
                ", confidential=" + con +
                '}';
    }


}
