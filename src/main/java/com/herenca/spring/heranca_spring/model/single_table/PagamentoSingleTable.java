package com.herenca.spring.heranca_spring.model.single_table;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    private BigDecimal valor;

    private LocalDate data;

    public abstract String processaPagamento();

   public static String getNomeInstituicao() {
       return nomeInstituicao;
   }






}
