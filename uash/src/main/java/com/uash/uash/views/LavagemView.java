package com.uash.uash.views;

import java.time.LocalDate;

public interface LavagemView {
    int getId();
    int getValor();
    String getTipoLavagem();
    String getLocalizacao();
    LocalDate getHorario();
    String getStatus();
    Integer getRating();
    String getVeiculoTipo();

    public Integer getUasherId();

    public Integer getVeiculoId();

}