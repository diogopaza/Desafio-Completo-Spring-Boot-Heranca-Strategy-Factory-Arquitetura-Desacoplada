package com.herenca.spring.heranca_spring.model.single_table;


import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
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

    @Override
    public PagamentoDTO toDTO() {
        return new PagamentoDTO(
                "Cartao",
                getValor(),
                getData(),
                null,
                getNumeroCartao(),
                null
        );
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
