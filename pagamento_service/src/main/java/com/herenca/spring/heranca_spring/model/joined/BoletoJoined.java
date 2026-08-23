package com.herenca.spring.heranca_spring.model.joined;

import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "boleto_joined")
@PrimaryKeyJoinColumn(name = "pagamento_id")
public class BoletoJoined extends PagamentoJoined {

    private String numeroBoleto;

    @Override
    public String processaPagamento() {
        return "Pagando no boleto";
    }

    @Override
    public PagamentoDTO toDTO() {
        return new PagamentoDTO(
                "BOLETO",
                this.getValor(),
                this.getData(),
                this.getNumeroBoleto(),
                null,
                null,
                UUID.randomUUID()
        );
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }
}
