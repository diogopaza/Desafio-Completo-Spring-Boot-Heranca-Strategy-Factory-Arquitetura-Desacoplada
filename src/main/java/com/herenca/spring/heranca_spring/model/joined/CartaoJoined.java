package com.herenca.spring.heranca_spring.model.joined;


import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.enums.PagamentoEnum;
import jakarta.persistence.*;


@Entity
@Table(name = "cartao_joined")
@PrimaryKeyJoinColumn(name = "pagamento_id")
public class CartaoJoined extends PagamentoJoined {

    private String numeroCartao;

    @Override
    public String processaPagamento() {
        return "Pagando no cartao";
    }

    @Override
    public PagamentoDTO toDTO() {
        return new PagamentoDTO(
                "CARTAO",
                this.getValor(),
                this.getData(),
                null,
                this.getNumeroCartao(),
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
