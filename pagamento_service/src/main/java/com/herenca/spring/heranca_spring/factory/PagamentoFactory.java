package com.herenca.spring.heranca_spring.factory;

import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.dto.PagamentoRequestDTO;
import com.herenca.spring.heranca_spring.model.single_table.Boleto;
import com.herenca.spring.heranca_spring.model.single_table.Cartao;
import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import com.herenca.spring.heranca_spring.model.single_table.Pix;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class PagamentoFactory {

    private Map<String, Function<PagamentoRequestDTO, PagamentoSingleTable>> mapPagamentoSingleTable;

    public PagamentoFactory() {
        mapPagamentoSingleTable = new HashMap<>();
        mapPagamentoSingleTable.put("PIX", dados -> {
            Pix pix = new Pix();
            pix.setChavePix(dados.chavePix());
            return pix;
        });
        mapPagamentoSingleTable.put("CARTAO", dados -> {
            Cartao cartao = new Cartao();
            cartao.setNumeroCartao(dados.numeroCartao());
            return cartao;
        });
        mapPagamentoSingleTable.put("BOLETO", dados -> {
            Boleto boleto = new Boleto();
            boleto.setNumeroBoleto(dados.numeroBoleto());
            return boleto;
        });
    }

    public PagamentoSingleTable create(PagamentoRequestDTO pagamentoRequestDTO) {
        var pagamento = mapPagamentoSingleTable.get(pagamentoRequestDTO.tipoPagamento().toUpperCase());
        if (pagamento != null) {
            PagamentoSingleTable pagamentoSingleTable = pagamento.apply(pagamentoRequestDTO);
            pagamentoSingleTable.setData(pagamentoRequestDTO.dataPagamento());
            pagamentoSingleTable.setValor(pagamentoRequestDTO.valor());
            return pagamentoSingleTable;

        }
        throw new IllegalArgumentException("Tipo de pagamento vazio");
    }

}





