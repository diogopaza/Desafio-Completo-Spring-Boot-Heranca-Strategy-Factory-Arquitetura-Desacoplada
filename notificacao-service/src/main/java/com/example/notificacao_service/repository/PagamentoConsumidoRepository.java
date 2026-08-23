package com.example.notificacao_service.repository;

import com.example.notificacao_service.model.PagamentoConsumido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PagamentoConsumidoRepository extends JpaRepository<PagamentoConsumido, Integer> {

    Optional<PagamentoConsumido> findByIdempotencyKey(UUID idempotencyKey);
}
