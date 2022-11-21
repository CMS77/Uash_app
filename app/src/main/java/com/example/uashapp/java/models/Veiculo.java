package com.example.uashapp.java.models;

import java.util.HashMap;

public class Veiculo {
    private static int currentID = 1;
    private final int id;
    private final String type;
    private final String registry; // TODO: poderá ser renovado??
    private String place;
    private HashMap<Integer, User> owners;

    public Veiculo(String newType, String newRegistry) {
        this.type = newType;
        this.registry = newRegistry;
        this.id = currentID;
        this.owners = new HashMap<Integer, User>();
        currentID++;
    }

    public Veiculo(String newType, String newRegistry, String newPlace) {
        this.type = newType;
        this.registry = newRegistry;
        this.place = newPlace;
        this.id = currentID;
        this.owners = new HashMap<Integer, User>();
        currentID++;
    }

    public int getID() {
        return this.id;
    }
    public String getType() {
        return this.type;
    }
    public String getPlace() {
        return this.place;
    }
    public String getRegistry() {
        return this.registry;
    }
    public HashMap<Integer, User> getOwners() { return this.owners; }

    public void setPlace(String newPlace) {
        this.place = newPlace;
    }
    public void addOwner(User newOwner) { this.getOwners().put(newOwner.getID(), newOwner); }
    public void removeOwner(User pendingOwner) {
        this.owners.remove(pendingOwner.getID());
    }
}
