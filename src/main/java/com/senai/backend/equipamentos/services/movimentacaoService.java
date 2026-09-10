package com.senai.backend.equipamentos.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.equipamentos.models.movimentacao;
import com.senai.backend.equipamentos.repositories.EquipamentoRepository;
import com.senai.backend.equipamentos.repositories.UsuarioRepository;
import com.senai.backend.equipamentos.repositories.movimentacaoRepository;

@Service
public class movimentacaoService {

    @Autowired 
    private movimentacaoRepository movimentacaoRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public movimentacao movimentar(
            Long idEquipamento,
            Long idUsuario,
            String tipo,
            Integer quantidade) {

        var equipamento = equipamentoRepository
                .findById(idEquipamento)
                .orElseThrow(() ->
                    new RuntimeException("Equipamento não encontrado")
                );

        var usuario = usuarioRepository
                .findById(idUsuario)
                .orElseThrow(() ->
                    new RuntimeException("Usuário não encontrado")
                );

        if (tipo.equalsIgnoreCase("entrada")) {

            equipamento.setQuantidade(
                equipamento.getQuantidade() + quantidade
            );

        } else if (tipo.equalsIgnoreCase("saida")) {

            if (equipamento.getQuantidade() < quantidade) {
                throw new RuntimeException(
                    "Quantidade insuficiente em estoque"
                );
            }

            equipamento.setQuantidade(
                equipamento.getQuantidade() - quantidade
            );

        } else {
            throw new RuntimeException(
                "Tipo de movimentação inválido"
            );
        }

        equipamentoRepository.save(equipamento);

        movimentacao movimentacao = new movimentacao();

        movimentacao.setTipo(tipo.toUpperCase());
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setQuantidade(quantidade);

        movimentacao.setEquipamento(equipamento);
        movimentacao.setUsuario(usuario);

        return movimentacaoRepository.save(movimentacao);
    }

        public List<movimentacao> listarMovimentacoes() {
        return movimentacaoRepository.findAll();
    }
}