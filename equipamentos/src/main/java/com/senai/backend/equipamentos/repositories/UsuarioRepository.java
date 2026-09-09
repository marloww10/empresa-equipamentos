package com.senai.backend.equipamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.backend.equipamentos.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}