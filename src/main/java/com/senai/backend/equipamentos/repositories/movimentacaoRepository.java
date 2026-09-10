package com.senai.backend.equipamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.backend.equipamentos.models.movimentacao;

public interface movimentacaoRepository extends JpaRepository<movimentacao, Long> {
    
}
