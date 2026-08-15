package com.herenca.spring.heranca_spring.service;


import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.dto.PagamentoRequestDTO;
import com.herenca.spring.heranca_spring.factory.PagamentoFactory;
import com.herenca.spring.heranca_spring.model.single_table.MultaAtrasoStrategy;
import com.herenca.spring.heranca_spring.model.single_table.MultaFixa;
import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import com.herenca.spring.heranca_spring.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

@Service
public class PagamentoService {

    private PagamentoRepository pagamentoRepository;
    private final NotificacaoPagamentoService notificacaoPagamentoService;
    private final Map<String, MultaAtrasoStrategy> multaAtrasoStrategy;

    public PagamentoService(PagamentoRepository pagamentoRepository,
                            NotificacaoPagamentoService notificacaoPagamentoService,
                            Map<String, MultaAtrasoStrategy> multaAtrasoStrategy) {
        this.pagamentoRepository = pagamentoRepository;
        this.notificacaoPagamentoService = notificacaoPagamentoService;
        this.multaAtrasoStrategy = multaAtrasoStrategy;
    }

    public PagamentoDTO buscaPagamentoPorId(Integer id) {
        return pagamentoRepository.findById(id)
                .map(PagamentoSingleTable::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Erro ao bucar pagamento por id"));
    }

    public List<PagamentoDTO> buscaTodosPagamentos() {
        return pagamentoRepository.findAll()
                .stream()
                .map(PagamentoSingleTable::toDTO)
                .toList();
    }

    public List<PagamentoDTO> listarTodosPagamentosPorTipo(String tipo) {
        var lista = pagamentoRepository.listarTodosPagamentosPorTipo(tipo);

        return lista.stream()
                .map(PagamentoSingleTable::toDTO)
                .toList();
    }

    public PagamentoDTO criarPagamento(PagamentoRequestDTO pagamentoRequestDTO, UUID idempotencyKey) {
        PagamentoSingleTable pagamento = new PagamentoFactory().create(pagamentoRequestDTO, idempotencyKey);
        /*var pagamentoIdempotencyKey = pagamentoRepository.findAll().
                stream().
                filter(pagamentoBanco -> pagamentoBanco.getIdempotencyKey().equals(pagamento.getIdempotencyKey())).
                findFirst();*/
        var pagamentoIdempotencyKey = pagamentoRepository.findByIdempotencyKey(idempotencyKey);
        if(pagamentoIdempotencyKey.isPresent()) {
            return pagamentoIdempotencyKey.get().toDTO();
        }

        var pagamentoSalvo = pagamentoRepository.save(pagamento);

        var pagamentoBuscado = pagamentoRepository.findById(pagamentoSalvo.getId()).orElseThrow( () ->
                new IllegalArgumentException("Erro ao recuperar pagamento salvo."));
        if (pagamentoBuscado.getData().isBefore(LocalDate.now())) {
            var multa = Optional.ofNullable(multaAtrasoStrategy.get("percentual".toUpperCase())).
                    orElseThrow( () -> new IllegalArgumentException("Tipo de multa invalido"));
            pagamentoBuscado.setValor(multa.calcularMulta(pagamento.getValor(), new BigDecimal("2")));
            pagamentoRepository.save(pagamentoBuscado);
        }
        notificacaoPagamentoService.notificarCriacaoPagamento(pagamentoBuscado);
        return pagamentoBuscado.toDTO();

    }





    public BigDecimal calcularValorComMulta(BigDecimal valorPagamento, BigDecimal valormulta, String tipoMulta) {
        System.out.println("Calculando multa:: " + valorPagamento + " - " + valormulta + " - " + tipoMulta);
        MultaAtrasoStrategy multa = Optional.ofNullable(multaAtrasoStrategy.get(tipoMulta.toUpperCase()))
                .orElseThrow(() -> new IllegalArgumentException("Tipo de multa não encontrada!!!"));
        return multa.calcularMulta(valorPagamento, valormulta);
    }
}
