package com.example.notificacao_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notificacao")
public class NotificacaoController {

    @GetMapping
    public void receberNotificacaoSincrono(String dados) {
        System.out.println("Notificacao recebida de forma sincrona:: " + dados);
    }
}
