package com.senai.backend.equipamentos.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class movimentacao {
    
    //atributos
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private LocalDateTime data;
    private Integer quantidade;

    @ManyToOne 
    private Equipamento equipamento;

    @ManyToOne 
    private Usuario usuario;


    //construtor vazio
    public movimentacao() {
    }

    //construtor com parâmetros
    public movimentacao(Long id, String tipo, LocalDateTime data, Integer quantidade, Equipamento equipamento,
            Usuario usuario) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.quantidade = quantidade;
        this.equipamento = equipamento;
        this.usuario = usuario;
    }

    //getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
