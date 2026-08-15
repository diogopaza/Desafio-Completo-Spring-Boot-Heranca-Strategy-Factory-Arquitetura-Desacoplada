package com.herenca.spring.heranca_spring.repository;

import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoSingleTable, Integer> {

    @Query("SELECT p FROM PagamentoSingleTable p where UPPER(p.type) = UPPER(:type)")
    public List<PagamentoSingleTable> listarTodosPagamentosPorTipo(@Param("type") String type);

    Optional<PagamentoSingleTable> findByIdempotencyKey(UUID idempotencyKey);
}
