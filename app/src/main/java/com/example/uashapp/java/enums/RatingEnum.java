package com.example.uashapp.java.enums;

public enum RatingEnum {
    EXCELENTE, BOM, MEDIO, RUIM, MUITORUIM;

    private int rating;
    void RatingOpcao(int ratingOp){
        rating = ratingOp;
    }
    public int ratingOp(){
        return rating;
    }

}