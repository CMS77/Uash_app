package com.uash.uash.model;

import lombok.Getter;

@Getter


public class Response {
    private String message;
    //objeto são as classes
    private Object object;
    public Response(String message, Object object) {
        this.message = message;
        this.object = object;
    } 
}
