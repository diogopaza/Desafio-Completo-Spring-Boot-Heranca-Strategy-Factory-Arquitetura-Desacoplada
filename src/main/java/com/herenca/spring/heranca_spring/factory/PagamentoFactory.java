package com.herenca.spring.heranca_spring.factory;

import com.herenca.spring.heranca_spring.model.single_table.Boleto;
import com.herenca.spring.heranca_spring.model.single_table.Cartao;
import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import com.herenca.spring.heranca_spring.model.single_table.Pix;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PagamentoFactory {

    private Map<String, Supplier<PagamentoSingleTable>> mapPagamentoSingleTable;

    public PagamentoFactory() {
        mapPagamentoSingleTable = new HashMap<>();
        mapPagamentoSingleTable.put("PIX", Pix::new);
        mapPagamentoSingleTable.put("CARTAO", Cartao::new);
        mapPagamentoSingleTable.put("BOLETO", Boleto::new);
    }

    public PagamentoSingleTable create(String tipo) {
        if (tipo != null) {
            PagamentoSingleTable pagamento = mapPagamentoSingleTable.get(tipo.toUpperCase()).get();
            if (pagamento != null) {
                return pagamento;
            }
        }
        throw new IllegalArgumentException("Tipo de pagamento vazio");
    }

}
