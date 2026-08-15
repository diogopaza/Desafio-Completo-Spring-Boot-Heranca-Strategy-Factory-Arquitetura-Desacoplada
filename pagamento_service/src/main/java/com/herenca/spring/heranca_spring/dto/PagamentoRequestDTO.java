package com.herenca.spring.heranca_spring.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PagamentoRequestDTO(String tipoPagamento, BigDecimal valor,
                                  String numeroBoleto, String numeroCartao, String chavePix,
                                  LocalDate dataPagamento) {
}
