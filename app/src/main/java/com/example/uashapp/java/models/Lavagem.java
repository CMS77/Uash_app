package com.example.uashapp.java.models;

import com.example.uashapp.java.enums.RatingEnum;
import com.example.uashapp.java.enums.StatusEnum;
import com.example.uashapp.java.enums.TipoLavagemEnum;

import java.time.LocalDateTime;

public class Lavagem {
    private static int currentID = 1;
    private int id;
    private int value;
    private TipoLavagemEnum washType;
    private String place;
    private LocalDateTime time;
    private StatusEnum status;

    public Lavagem(int newValue, TipoLavagemEnum newWashType, String newPlace, LocalDateTime newTime) {
        this.id = currentID;
        this.value = newValue;
        this.washType = newWashType;
        this.place = newPlace;
        this.time = newTime;
        this.status = StatusEnum.SOLICITADO;
        currentID++;
    }

    public int getID() {
        return this.id;
    }
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
}
