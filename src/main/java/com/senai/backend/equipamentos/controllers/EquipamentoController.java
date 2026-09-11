package com.senai.backend.equipamentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.equipamentos.models.Equipamento;
import com.senai.backend.equipamentos.services.EquipamentoService;


@RestController 
@RequestMapping("/equipamentos")
public class EquipamentoController {
    
    @Autowired 
    private EquipamentoService equipamentoService;

    @GetMapping ("/contar-equipamentos")
    public Long contarEquipamentos() {
        return equipamentoService.contarEquipamento();
    
    }

    @GetMapping ("/buscar-equipamento/{id}")
    public Equipamento buscarEquipamento(@PathVariable Long id) {
        return equipamentoService.buscarEquipamento(id);
    }

    @GetMapping ("/listar-equipamentos")
    public List<Equipamento> listarEquipamentos() {
        return equipamentoService.listarEquipamentos();
    }

    @PostMapping ("/cadastrar-equipamento")
    public Equipamento cadastrarEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoService.cadastrarEquipamento(equipamento);    
    }

    @DeleteMapping ("/deletar-equipamento/{id}")
    public String deletarEquipamento(@PathVariable Long id) {
        if (equipamentoService.deletarEquipamento(id)) {
            return "Equipamento deletado com sucesso!";
        }
        return "Equipamento não encontrado!";
    }

    @PutMapping("/atualizar-equipamento/{id}")
    public Equipamento atualizarEquipamento(
            @PathVariable Long id,
            @RequestBody Equipamento equipamento
    ) {
        return equipamentoService.atualizarEquipamento(
            id,
            equipamento
        );
    }

    @GetMapping("/estoque-minimo")
    public List<Equipamento> listarEstoqueMinimo() {
        return equipamentoService.listarEstoqueMinimo();

    }

}
