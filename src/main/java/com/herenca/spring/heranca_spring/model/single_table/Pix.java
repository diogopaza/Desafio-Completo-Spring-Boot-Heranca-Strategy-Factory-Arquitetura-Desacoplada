package com.herenca.spring.heranca_spring.model.single_table;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Pix")
public class Pix extends PagamentoSingleTable {

    private String chavePix;
    @Override
    public String processaPagamento() {
        return "Pagando com PIX";
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
