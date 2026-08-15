package com.herenca.spring.heranca_spring.model.single_table;

import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(
        name = "pagamento_single_table",
        indexes = {
                @Index(name = "idx_pagamento_type", columnList = "type")
        }
)
public abstract class PagamentoSingleTable {

    private static final String nomeInstituicao = "Banco Paza";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    private BigDecimal valor;

    private LocalDate data;

    @Column(name = "idempotency_key", nullable = false, unique = true)
    private UUID idempotencyKey;

    public abstract String processaPagamento();

   public static String getNomeInstituicao() {
       return nomeInstituicao;
   }

    public abstract PagamentoDTO toDTO();

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(UUID idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }
}
