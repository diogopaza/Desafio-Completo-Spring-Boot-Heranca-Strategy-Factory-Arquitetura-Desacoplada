package com.herenca.spring.heranca_spring.model.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Boleto")
public class Boleto extends PagamentoSingleTable {

    private String numeroBoleto;

    @Override
    public String processaPagamento() {
        return "Pagando no boleto";
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }
}
