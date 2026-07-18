package com.herenca.spring.heranca_spring.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoDTO(String tipoPagamento, BigDecimal valor, LocalDate data,
                           String numeroBoleto, String numeroCartao, String chavePix) {


}
