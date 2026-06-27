package com.herenca.spring.heranca_spring.service;

import com.herenca.spring.heranca_spring.controller.PagamentoController;
import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.model.joined.PagamentoJoined;
import com.herenca.spring.heranca_spring.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public PagamentoDTO buscaPagamentoPorId(Long id)  {
           return pagamentoRepository.findById(id)
                   .map(PagamentoJoined::toDTO)
                   .orElseThrow(() -> new IllegalArgumentException("Erro ao bucar pagamento por id"));
    }

    public List<PagamentoDTO> buscaTodosPagamentos() {
        return pagamentoRepository.findAll()
                .stream()
                .map(PagamentoJoined::toDTO)
                .toList();
    }
}
