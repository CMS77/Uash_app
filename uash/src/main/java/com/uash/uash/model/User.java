package com.uash.uash.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="usuario")
@Setter
@Getter

public class User {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name= "user_nome")
    private String nome;
    @Column(name= "user_email")
    private String email;
    @Column(name= "user_pass")
    private String password;
    @Column(name= "user_tel")
    private int telefone;
    @Column(name= "user_dt_nasc")
    private LocalDate dataNasc;
    @Column(name= "user_loc")
    private String localizacao;

    @OneToMany
    @JoinColumn(name = "user_uashers_fav")
    private List<Uasher> uashers;

    public User(int id){
        this.id = id;
    }

    public User(){}
    
}
