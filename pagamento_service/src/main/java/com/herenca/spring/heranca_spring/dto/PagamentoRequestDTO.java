package com.herenca.spring.heranca_spring.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoRequestDTO(@NotNull(message = "O campo tipo pagamento não pode ser null.")
                                  @NotBlank(message = "O campo tipo pagamento não pode ser vazio.")
                                  String tipoPagamento,
                                  @DecimalMin(value = "0.01", message = "O valor minímo do " +
                                          "pagamento e 0.01 centavos")
                                  @Digits(integer = 10, fraction = 2)
                                  @NotNull(message = "O campo valor não pode ser null.")
                                  BigDecimal valor,
                                  String numeroBoleto,
                                  String numeroCartao,
                                  String chavePix,
                                  @NotNull(message = "O data de pagamento não pode ser null.")
                                  LocalDate dataPagamento) {
}
