package com.herenca.spring.heranca_spring.model.teste.primary_key_join_column;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartao_teste")
@PrimaryKeyJoinColumn(name = "pagamento_id")
public class CartaoTeste extends PagamentoTeste{
    private String numeroCartao;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
