package com.senai.backend.equipamentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.equipamentos.models.movimentacao;
import com.senai.backend.equipamentos.services.movimentacaoService;



@RestController 
@RequestMapping("/movimentacoes")
public class movimentacaoController {
    
    @Autowired 
    private movimentacaoService movimentacaoService;

    @PostMapping("/movimentar")
    public movimentacao movimentar(
        @RequestParam Long idEquipamento,
        @RequestParam Long idUsuario,
        @RequestParam String tipo,
        @RequestParam Integer quantidade) {
        return movimentacaoService.movimentar(
            idEquipamento,
            idUsuario,
            tipo,
            quantidade);
    }

    @GetMapping("/historico")
    public List<movimentacao> listarmovimentacoes() {
        return movimentacaoService.listarMovimentacoes();
    }
    
}
