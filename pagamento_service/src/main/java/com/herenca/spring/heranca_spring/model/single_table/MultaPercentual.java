package com.herenca.spring.heranca_spring.model.single_table;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("PERCENTUAL")
public class MultaPercentual implements MultaAtrasoStrategy{

    @Override
    public BigDecimal calcularMulta(BigDecimal valorPagamento, BigDecimal valorPorcentagemMulta) {
        var multa =  (valorPagamento.divide(new BigDecimal("100")).multiply(valorPorcentagemMulta));
        return valorPagamento.add(multa);
    }
}
