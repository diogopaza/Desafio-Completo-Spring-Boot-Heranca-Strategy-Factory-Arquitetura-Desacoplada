package com.herenca.spring.heranca_spring.repository;

import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoSingleTable, Integer> {
}
