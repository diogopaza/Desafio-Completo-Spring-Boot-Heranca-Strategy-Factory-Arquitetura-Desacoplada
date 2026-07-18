package com.herenca.spring.heranca_spring.service;

import com.herenca.spring.heranca_spring.config.RabbitMQConfig;
import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Service
public class NotificacaoPagamentoService {

    private final RestClient restClient = RestClient.create();
    private final RabbitTemplate rabbitTemplate;

    public NotificacaoPagamentoService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @CircuitBreaker(
            name = "pagamentoServiceCircuitBreaker",
            fallbackMethod = "notificarCriacaoPagamentoAssincrono"
    )
    public String notificarCriacaoPagamento(PagamentoSingleTable pagamento) {
        System.out.println("Notificando novo pagamento");
        return restClient.get()
                .uri("http://localhost:8081/notificacao")
                .retrieve()
                .body(String.class);
    }

    public String notificarCriacaoPagamentoAssincrono(PagamentoSingleTable pagamento, Throwable t) {
        System.out.println("Enviando pagamento para a fila ===  " + RabbitMQConfig.QUEUE_NOTIFICACAO);
        MessagePostProcessor addCorrelationId = message -> {
            message.getMessageProperties().setHeader("correlationId", UUID.randomUUID().toString());
            return message;
        };
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NOTIFICACAO, pagamento.toDTO(), addCorrelationId);
        return "Notificação enviada via fila (circuito aberto: " + t.getMessage() + ")";
    }
}
