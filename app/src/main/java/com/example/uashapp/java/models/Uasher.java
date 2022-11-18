package com.example.uashapp.java.models;

public class Uasher {
    private static int currentID = 1;
    private int id;
    private User user;
    private String license;
    private boolean hasEquipment;
    private String place;

    public Uasher(User newUser, String newLicense) {
        this.user = newUser;
        this.license = newLicense;
        this.id = currentID;
        currentID++;
    }

    public int getID() {
        return this.id;
    }
    public User getUser() {
        return this.user;
    }
    public String getLicense() {
        return this.license;
    }
    public boolean getEquipment() {
        return this.hasEquipment;
    }
    public String getPlace() {
        return this.place;
    }

    public void setEquipment(Boolean newEquipment) { this.hasEquipment = newEquipment; }
    public void setPlace(String newPlace) { this.place = newPlace; }
}
