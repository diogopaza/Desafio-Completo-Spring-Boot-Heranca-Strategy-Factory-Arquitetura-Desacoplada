package com.example.notificacao_service.config;

import com.example.notificacao_service.dto.PagamentoDTO;
import com.example.notificacao_service.model.PagamentoConsumido;
import com.example.notificacao_service.repository.PagamentoConsumidoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;

@Configuration
public class NotificacaoListener {

    private final PagamentoConsumidoRepository pagamentoConsumidoRepository;

    public NotificacaoListener(PagamentoConsumidoRepository pagamentoConsumidoRepository) {
        this.pagamentoConsumidoRepository = pagamentoConsumidoRepository;
    }

    @RabbitListener(queues = "notificacao.pagamento")
    public void receberNotificacao(PagamentoDTO pagamentoDTO) throws InterruptedException {
        var pagamentoConsumido = new PagamentoConsumido();
        pagamentoConsumido.setIdempotencyKey(pagamentoDTO.idempotencyKey());
        try {
            pagamentoConsumidoRepository.save(pagamentoConsumido);
        } catch (Exception ex) {
            System.out.println("Erro de integridade --- EMAIL NÃO SERÁ ENVIADO");
            return;
        }
        Thread.sleep(2000);
        System.out.println("ENVIANDO EMAIL --- notificacao recebida de forma assincrona : " + pagamentoDTO);
        pagamentoConsumidoRepository.save(pagamentoConsumido);

    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }


}
