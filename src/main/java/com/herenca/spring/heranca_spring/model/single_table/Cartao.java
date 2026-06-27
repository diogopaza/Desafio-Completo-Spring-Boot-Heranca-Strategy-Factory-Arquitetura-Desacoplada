package com.herenca.spring.heranca_spring.model.single_table;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("Cartao")
public class Cartao extends PagamentoSingleTable {

    private String numeroCartao;

    @Override
    public String processaPagamento() {
        return "Pagando no cartao";
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
