package com.herenca.spring.heranca_spring.service;

import com.herenca.spring.heranca_spring.dto.PagamentoRequestDTO;
import com.herenca.spring.heranca_spring.factory.PagamentoFactory;
import com.herenca.spring.heranca_spring.model.single_table.MultaAtrasoStrategy;
import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Service
public class PatternIdentityTest {

    @Autowired
    private Map<String, MultaAtrasoStrategy> multaAtrasoStrategy;


    public void strategyDeveSerAMesmaInstancia() {
        MultaAtrasoStrategy primeira = multaAtrasoStrategy.get("PERCENTUAL");
        MultaAtrasoStrategy segunda = multaAtrasoStrategy.get("PERCENTUAL");

        System.out.println("Strategy 1: " + primeira);
        System.out.println("Strategy 2: " + segunda);
        System.out.println("São a mesma instância (Strategy)? " + (primeira == segunda));
    }


    public void factoryDeveCriarInstanciasDiferentes() {
        PagamentoRequestDTO dados = new PagamentoRequestDTO("PIX", new BigDecimal("100"),
                null, null, "chave-teste", LocalDate.now());

        PagamentoSingleTable primeiro = new PagamentoFactory().create(dados, UUID.randomUUID());
        PagamentoSingleTable segundo = new PagamentoFactory().create(dados, UUID.randomUUID());

        System.out.println("Pagamento 1: " + primeiro);
        System.out.println("Pagamento 2: " + segundo);
        System.out.println("São a mesma instância (Factory)? " + (primeiro == segundo));


    }
}
