package com.herenca.spring.heranca_spring.model.single_table;

import java.math.BigDecimal;

public interface MultaAtrasoStrategy {

    public abstract BigDecimal calcularMulta(BigDecimal valorPagamento,BigDecimal multa);

}
