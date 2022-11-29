// Não foi feito o GET e SET pois a dependencia do lombok faz automaticamente, deixando o codigo mais limpo e mais facil de entender.


package com.uash.uash.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="veiculo")
@Setter
@Getter

public class Veiculo {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name = "veiculo_id")
    private int id;
    @Column(name = "veiculo_tipo")
    private String tipo;
    @Column (name = "veiculo_loc")
    private String localizacao; 
    @Column (name = "veiculo_mat")
    private String matricula;
    @ManyToMany
    @JoinColumn(name = "veic_user")
    private List<User> users;  

    public Veiculo(){}

}