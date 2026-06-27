package com.herenca.spring.heranca_spring.repository;

import com.herenca.spring.heranca_spring.model.joined.PagamentoJoined;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoJoined, Long> {
}
