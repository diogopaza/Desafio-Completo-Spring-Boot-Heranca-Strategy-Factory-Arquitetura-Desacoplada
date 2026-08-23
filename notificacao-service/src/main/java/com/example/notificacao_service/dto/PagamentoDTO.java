package com.example.notificacao_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PagamentoDTO(String tipoPagamento, BigDecimal valor, LocalDate data,
                           String numeroBoleto, String numeroCartao, String chavePix, UUID idempotencyKey) {


}
