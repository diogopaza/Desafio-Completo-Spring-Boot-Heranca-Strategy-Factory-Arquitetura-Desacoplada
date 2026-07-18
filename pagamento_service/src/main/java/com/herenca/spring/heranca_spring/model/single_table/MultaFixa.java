package com.herenca.spring.heranca_spring.model.single_table;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("FIXA")
public class MultaFixa implements MultaAtrasoStrategy{

    @Override
    public BigDecimal calcularMulta(BigDecimal valorPagamento, BigDecimal valorFixoMulta) {
        return valorPagamento.add(valorFixoMulta);
    }
}
