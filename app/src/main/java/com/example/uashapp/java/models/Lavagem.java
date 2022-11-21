package com.example.uashapp.java.models;

import androidx.annotation.NonNull;

import com.example.uashapp.java.enums.RatingEnum;
import com.example.uashapp.java.enums.StatusEnum;
import com.example.uashapp.java.enums.TipoLavagemEnum;

import java.time.LocalDateTime;

public class Lavagem {
    private static int currentID = 1;
    private final int id;
    private final User client;
    private Uasher uasher;
    private int value;
    private TipoLavagemEnum washType;
    private String place;
    private LocalDateTime time;
    private StatusEnum status;

    public Lavagem(@NonNull User newClient, int newValue, TipoLavagemEnum newWashType, String newPlace, LocalDateTime newTime) {
        this.id = currentID;
        this.client = newClient;
        this.value = newValue;
        this.washType = newWashType;
        this.place = newPlace;
        this.time = newTime;
        this.status = StatusEnum.SOLICITADO;
        currentID++;
        newClient.addReqService(this);
    }

    public int getID() {
        return this.id;
    }
    public User getClient() { return this.client; }
    public Uasher getUasher() { return this.uasher; }
    public int getValue() {
        return this.value;
    }
    public TipoLavagemEnum getWashType() {
        return this.washType;
    }
    public String getPlace() {
        return this.place;
    }
    public LocalDateTime getTime() {
        return this.time;
    }
    public StatusEnum getStatus() {
        return this.status;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }
    public void setPlace(String newPlace) {
        this.place = newPlace;
    }
    public void setTime(LocalDateTime newTime) {
        this.time = newTime;
    }
    public void setStatus(StatusEnum newStatus) {
        this.status = newStatus;
    }
    public void setUasher(Uasher newUasher) { this.uasher = newUasher; }
    public void removeUasher() { this.uasher = null; } // talvez não seja necessário se setUasher aceitar null

    public void deleteService() {
        this.client.removeReqService(this);
        this.uasher.removeCurrentService(this);
        this.uasher = null;
    }
}
