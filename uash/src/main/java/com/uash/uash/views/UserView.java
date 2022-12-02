package com.uash.uash.views;

import java.time.LocalDate;


public interface UserView {
    int getId();
    String getName();
    String getEmail();
    int getTelefone();
    LocalDate getDataNasc();
    String getLocalizacao();
    
    
}