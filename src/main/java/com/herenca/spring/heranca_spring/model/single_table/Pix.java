package com.herenca.spring.heranca_spring.model.single_table;


import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
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

    @Override
    public PagamentoDTO toDTO() {
        return new PagamentoDTO(
                "Pix",
                getValor(),
                getData(),
                null,
                null,
                getChavePix()
        );
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
