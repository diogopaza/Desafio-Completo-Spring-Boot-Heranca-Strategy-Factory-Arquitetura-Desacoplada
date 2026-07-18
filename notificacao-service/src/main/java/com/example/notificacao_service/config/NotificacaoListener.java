package com.example.notificacao_service.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoListener {

    @RabbitListener(queues = "notificacao.pagamento")
    public void receberNotificacao(Message message) {
        System.out.println("Notificacao recebida de forma assincrona: " + new String(message.getBody()));
    }


}
