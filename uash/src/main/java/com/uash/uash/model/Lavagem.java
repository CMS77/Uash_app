// Model é a entidade do banco


package com.uash.uash.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="lavagem")
@Setter
@Getter

public class Lavagem {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name = "lavagem_id")
    private int id;
    @Column(name = "lavagem_val")
    private int valor;
    @Column(name = "lavagem_tipo")
    private String tipoLavagem;
    @Column(name = "lavagem_loc")
    private String localizacao; 
    @Column(name = "lavagem_hora")  
    private LocalDateTime horario;
    @Column(name = "lavagem_sta")
    private String status;
    @Column(name = "lavagem_rat")
    private int rating;
    @ManyToOne
    @JoinColumn(name = "lavagem_veic")
    private Veiculo veiculo;
    @ManyToOne
    @JoinColumn (name = "lavagem_uasher")
    private Uasher uasher;
    
}

