package com.herenca.spring.heranca_spring.controller;

import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.dto.PagamentoRequestDTO;
import com.herenca.spring.heranca_spring.factory.PagamentoFactory;
import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import com.herenca.spring.heranca_spring.service.PagamentoService;
import com.herenca.spring.heranca_spring.service.PatternIdentityTest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    private PagamentoService pagamentoService;

    private PatternIdentityTest patternIdentityTest;

    public PagamentoController(PagamentoService pagamentoService, PatternIdentityTest patternIdentityTest) {
        this.pagamentoService = pagamentoService;
        this.patternIdentityTest = patternIdentityTest;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> listaPagamentoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(pagamentoService.buscaPagamentoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> todosPagamentos() {
        return ResponseEntity.ok().body(pagamentoService.buscaTodosPagamentos());
    }

    @GetMapping(params = "tipo")
    public ResponseEntity<?> retornarPorTipoDePagamento(
            @RequestParam(required = false) String tipo) {
        if(tipo != null) {
            return ResponseEntity.ok().body(pagamentoService.listarTodosPagamentosPorTipo(tipo));
        }
        return ResponseEntity.badRequest().body("Defina um tipo de pagamento");
    }

    @PostMapping
    public PagamentoDTO criarPagamento(@RequestHeader("Idempotency-key") UUID idempotencyKey,
                                       @Valid @RequestBody PagamentoRequestDTO pagamentoRequestDTO) {
        return pagamentoService.criarPagamento(pagamentoRequestDTO, idempotencyKey);
    }

    @GetMapping("/calcularMulta")
    public BigDecimal calcularMulta(@RequestParam BigDecimal valorPagamento,
                                        @RequestParam BigDecimal valorMulta,
                                        @RequestParam String tipoMulta) {
        return pagamentoService.calcularValorComMulta(valorPagamento, valorMulta, tipoMulta);
    }

    @GetMapping("/testarStrategy")
    public void testStrategyAndFactory() {
        patternIdentityTest.strategyDeveSerAMesmaInstancia();
        patternIdentityTest.factoryDeveCriarInstanciasDiferentes();
    }



}
