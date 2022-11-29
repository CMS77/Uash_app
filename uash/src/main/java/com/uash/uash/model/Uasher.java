package com.uash.uash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="uasher")
@Setter
@Getter

public class Uasher {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name = "uasher_id")
    private int id;
    @Column(name = "uasher_rat")
    private int rating;
    @Column(name = "uasher_carta")
    private String cartaConducao;
    @Column(name = "uasher_mat")
    private boolean material;
    @Column(name = "uasher_loc")
    private String localizacao;
    @OneToOne
    @JoinColumn (name = "uasher_user")
    private User user;  
}