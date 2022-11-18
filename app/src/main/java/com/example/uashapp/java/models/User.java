package com.example.uashapp.java.models;

import com.example.uashapp.java.enums.RatingEnum;

public class User {
    private static int currentID = 1;
    private int id;
    private String name;
    private String password; //hashed
    private String email;
    private int phone;
    private int age;
    private String place;
    private RatingEnum rating;

    public User(String newName, String newEmail, int newPhone, String newPlace) {
        this.name = newName;
        this.email = newEmail;
        this.phone = newPhone;
        this.place = newPlace;
        this.id = currentID;
        currentID++;
    }

    public int getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public int getPhone() {
        return this.phone;
    }
    public int getAge() {
        return this.age;
    }
    public String getPlace() {
        return this.place;
    }
    public RatingEnum getRating() {
        return this.rating;
    }

    public void setName(String newName) {
        this.name = newName;
    }
    public void setPassword(String newPassword) {
        String encryptedPassword = newPassword;
        this.password = encryptedPassword;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public void setPhone(int newPhone) {
        this.phone = newPhone;
    }
    public void setPlace(String newPlace) {
        this.place = newPlace;
    }
    public void setRating(RatingEnum newRating) {
        this.rating = newRating;
    }
}
