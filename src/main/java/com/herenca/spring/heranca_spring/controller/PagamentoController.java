package com.herenca.spring.heranca_spring.controller;

import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.model.joined.PagamentoJoined;
import com.herenca.spring.heranca_spring.service.PagamentoService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    private PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/pagamento/{id}")
    public ResponseEntity<PagamentoDTO> listaPagamentoPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(pagamentoService.buscaPagamentoPorId(id));
    }

    @GetMapping("/pagamentos")
    public ResponseEntity<List<PagamentoDTO>> todosPagamentos() {
        return ResponseEntity.ok().body(pagamentoService.buscaTodosPagamentos());
    }

    @PostMapping("/receber-pagamento")
    public void receberPagamento() {

    }


}
