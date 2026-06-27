package com.herenca.spring.heranca_spring.enums;

public enum PagamentoEnum {
    PIX("Pagamento via PIX"),
    BOLETO("Pagamento via BOLETO"),
    CARTAO("Pagamento via CARTÃO");

    private final String tipoPagamento;

    PagamentoEnum(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoPagamento() {
        return this.tipoPagamento;
    }


}
