package com.herenca.spring.heranca_spring.repository;

import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.model.single_table.PagamentoSingleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoSingleTable, Integer> {

    @Query("SELECT p FROM PagamentoSingleTable p where p.type = :type")
    public List<PagamentoDTO> listarTodosPagamentosPorTipo(String type);
}
