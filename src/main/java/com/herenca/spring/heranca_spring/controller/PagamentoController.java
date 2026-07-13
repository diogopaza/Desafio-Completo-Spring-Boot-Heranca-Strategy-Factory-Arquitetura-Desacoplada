package com.herenca.spring.heranca_spring.controller;

import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    private PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> listaPagamentoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(pagamentoService.buscaPagamentoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> todosPagamentos() {
        return ResponseEntity.ok().body(pagamentoService.buscaTodosPagamentos());
    }

    @PostMapping()
    public void receberPagamento() {

    }


}
