package com.herenca.spring.heranca_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PagamentoRequestDTO(@NotNull @NotBlank String tipoPagamento,
                                  @Positive @NotNull BigDecimal valor, String numeroBoleto,
                                  String numeroCartao,
                                  String chavePix,
                                  @NotNull LocalDate dataPagamento) {
}
