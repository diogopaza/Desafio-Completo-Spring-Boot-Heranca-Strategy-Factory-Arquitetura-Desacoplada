package com.herenca.spring.heranca_spring.service;


import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.dto.PagamentoRequestDTO;
import com.herenca.spring.heranca_spring.factory.PagamentoFactory;
import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import com.herenca.spring.heranca_spring.repository.PagamentoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private PagamentoRepository pagamentoRepository;
    private final NotificacaoPagamentoService notificacaoPagamentoService;


    public PagamentoService(PagamentoRepository pagamentoRepository, NotificacaoPagamentoService notificacaoPagamentoService) {
        this.pagamentoRepository = pagamentoRepository;
        this.notificacaoPagamentoService = notificacaoPagamentoService;
    }

    public PagamentoDTO buscaPagamentoPorId(Integer id)  {
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

    public PagamentoDTO criarPagamento(PagamentoRequestDTO pagamentoRequestDTO) {
        PagamentoSingleTable pagamento = new PagamentoFactory().create(pagamentoRequestDTO);
        pagamentoRepository.save(pagamento);
        notificacaoPagamentoService.notificarCriacaoPagamento(pagamento);
        return pagamento.toDTO();
    }


}
