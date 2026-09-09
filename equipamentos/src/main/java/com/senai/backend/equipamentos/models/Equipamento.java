package com.senai.backend.equipamentos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Equipamento {
    
    //atributos
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String categoria;
    private Double potencia;
    private String material;
    private Double peso;
    private Double dimensao;
    private String cor;
    private Double quantidade;
    private Double quantidademinima;

    //construtor vazio
    public Equipamento() {
    }

    
    //construtor com parâmetros
    public Equipamento(Long id, String marca, String modelo, String categoria, Double potencia, String material,
            Double peso, Double dimensao, String cor, Double quantidade, Double quantidademinima) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.potencia = potencia;
        this.material = material;
        this.peso = peso;
        this.dimensao = dimensao;
        this.cor = cor;
        this.quantidade = quantidade;
        this.quantidademinima = quantidademinima;
    }

    //getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Double getPotencia() {
        return potencia;
    }
    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public Double getDimensao() {
        return dimensao;
    }
    public void setDimensao(Double dimensao) {
        this.dimensao = dimensao;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public Double getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
    public Double getQuantidademinima() {
        return quantidademinima;
    }
    public void setQuantidademinima(Double quantidademinima) {
        this.quantidademinima = quantidademinima;
    }

}
