package com.herenca.spring.heranca_spring.dto;

import com.herenca.spring.heranca_spring.enums.PagamentoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoDTO(String tipoPagamento, BigDecimal valor, LocalDate data,
                           String numeroBoleto, String numeroCartao, String chavePix) {
}
