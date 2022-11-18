package com.example.uashapp.java.models;

public class Veiculo {
    private static int currentID = 1;
    private int id;
    private final String type;
    private final String registry;
    private String place;

    public Veiculo(String newType, String newRegistry) {
        this.type = newType;
        this.registry = newRegistry;
        this.id = currentID;
        currentID++;
    }

    public Veiculo(String newType, String newRegistry, String newPlace) {
        this.type = newType;
        this.registry = newRegistry;
        this.place = newPlace;
        this.id = currentID;
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

    public void setPlace(String newPlace) {
        this.place = newPlace;
    }
}
