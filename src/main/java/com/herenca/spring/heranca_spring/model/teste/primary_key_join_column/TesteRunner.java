package com.herenca.spring.heranca_spring.model.teste.primary_key_join_column;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TesteRunner {

    public CommandLineRunner testePagamento(CartaoRepositoryTeste cartaoRepositoryTeste) {
        return args -> {
            CartaoTeste cartaoTeste = new CartaoTeste();
            cartaoTeste.setNumeroCartao("111-888");
            cartaoTeste.setValor(200D);

            cartaoRepositoryTeste.save(cartaoTeste);

            System.out.println("Cartao salvo com sucesso!!!");

            cartaoRepositoryTeste.findAll().forEach( cartao ->
                    System.out.println(cartao.getId() + " - " + cartao.getValor())
            );
            };
        }

}
