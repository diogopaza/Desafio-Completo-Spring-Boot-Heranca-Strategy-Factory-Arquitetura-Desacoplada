package com.example.notificacao_service;

import com.example.notificacao_service.config.NotificacaoListener;
import com.example.notificacao_service.dto.PagamentoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class NotificacaoServiceApplicationTests {

	@Autowired
	private NotificacaoListener notificacaoListener;

	@Test
	void deveProcessarApenasUmaVezComMesmoKeyIndempotencia () throws InterruptedException {
		System.out.println("Thread principal:: " + Thread.currentThread().getName());
		//UUID uuidPagamentoFixo = new UUID.fromString("74206eca-0a71-40a7-87ed-2b4c38f3eef0");
		int totalThreads = 5;
		var listaPagamentosDTO = criarPagamentosDeTeste();

		ExecutorService executorService = Executors.newFixedThreadPool(totalThreads);
		CountDownLatch countDownLatch = new CountDownLatch(totalThreads);
		for (int i = 0; i < totalThreads; i++) {
			int numeroDaThread = i;
			executorService.submit(() -> {
				System.out.println("Thread " + numeroDaThread + " rodando em: " + Thread.currentThread().getName());
				System.out.println("RABBITMQ ENVIANDO MENSAGEM");
				try {
					notificacaoListener.receberNotificacao(listaPagamentosDTO.get(numeroDaThread));
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				countDownLatch.countDown();
			});
		}
		//trava a thread principal ate as outras finalizarem
		countDownLatch.await();
	}

	//@Test
	void contextLoads() {
	}

	private List<PagamentoDTO> criarPagamentosDeTeste() {
		UUID uuidDuplicado = UUID.randomUUID();

		PagamentoDTO dto1 = new PagamentoDTO("PIX", new BigDecimal("100.00"), LocalDate.now(),
				null, null, "chave-pix-1", uuidDuplicado);

		PagamentoDTO dto2 = new PagamentoDTO("CARTAO", new BigDecimal("250.50"), LocalDate.now(),
				null, "1234-5678-9012", null, UUID.randomUUID());

		PagamentoDTO dto3 = new PagamentoDTO("PIX", new BigDecimal("100.00"), LocalDate.now(),
				null, null, "chave-pix-1", uuidDuplicado); // mesma key do dto1 -- duplicata proposital

		PagamentoDTO dto4 = new PagamentoDTO("BOLETO", new BigDecimal("75.00"), LocalDate.now(),
				"00190.00009 03398.765432 10123.456789 1 12340000007500", null, null, UUID.randomUUID());

		PagamentoDTO dto5 = new PagamentoDTO("CARTAO", new BigDecimal("500.00"), LocalDate.now(),
				null, "9999-8888-7777", null, uuidDuplicado);

		return List.of(dto1, dto2, dto3, dto4, dto5);
	}

}
