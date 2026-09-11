package com.senai.backend.equipamentos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.equipamentos.models.Equipamento;
import com.senai.backend.equipamentos.repositories.EquipamentoRepository;

@Service 
public class EquipamentoService {
    
    @Autowired 
    private EquipamentoRepository equipamentoRepository;

    public Long contarEquipamento() {
        return equipamentoRepository.count();
    }

    public Equipamento cadastrarEquipamento(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listarEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarEquipamento(long id) {
        return equipamentoRepository.findById(id).get();
    }

    public boolean deletarEquipamento(long id) {
        if (equipamentoRepository.existsById(id)) {
            equipamentoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Equipamento atualizarEquipamento(long id, Equipamento equipamento) {
        if (equipamentoRepository.existsById(id)) {
            equipamento.setId(id);
            return equipamentoRepository.save(equipamento);
        } else {
            return null;
        }
    }

    public List<Equipamento> listarEstoqueMinimo() {
    return equipamentoRepository.findAll()
        .stream()
        .filter(equipamento ->
            equipamento.getQuantidade() <= equipamento.getQuantidademinima()
        )
        .toList();
}

}
