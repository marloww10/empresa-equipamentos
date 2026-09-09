package com.senai.backend.equipamentos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.equipamentos.models.Usuario;
import com.senai.backend.equipamentos.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Long contarUsuario() {
        return usuarioRepository.count();
    }

    public Usuario buscarUsuario(long id) {
        return usuarioRepository.findById(id).get();
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean deletarUsuario(long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Usuario fazerLogin(String email, String senha) {
    Usuario usuario = usuarioRepository.findByEmail(email);

    if (usuario != null && usuario.getSenha().equals(senha)) {
        return usuario;
    }

    return null;
}
}