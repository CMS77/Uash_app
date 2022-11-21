package com.example.uashapp.java.models;

import androidx.annotation.NonNull;

// Não usado atualmente

public class UserVeiculos {
    private int userID;
    private int vehicleID;
    UserVeiculos(@NonNull User newUser, @NonNull Veiculo newVehicle) {
        this.userID = newUser.getID();
        this.vehicleID = newVehicle.getID();
    }

}
