package com.senai.backend.equipamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.backend.equipamentos.models.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    
}
