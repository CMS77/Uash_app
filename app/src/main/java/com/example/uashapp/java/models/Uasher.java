package com.example.uashapp.java.models;

import java.util.HashMap;

public class Uasher {
    private static int currentID = 1;
    private final int id;
    private final User user;
    private final String license; // TODO: poderá ser renovada, mudar mais tarde
    private boolean hasEquipment;
    private String place;
    private HashMap<Integer, Lavagem> currentServices;

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
    public HashMap<Integer, Lavagem> getCurrentServices() { return this.currentServices; }

    public void setEquipment(Boolean newEquipment) { this.hasEquipment = newEquipment; }
    public void setPlace(String newPlace) { this.place = newPlace; }
    public void addReqService(Lavagem newService) {
        newService.setUasher(this);
        this.currentServices.put(newService.getID(), newService);
    }
    public void removeCurrentService(Lavagem pendingService) {
        pendingService.removeUasher();
        this.currentServices.remove(pendingService.getID());
    }
}
