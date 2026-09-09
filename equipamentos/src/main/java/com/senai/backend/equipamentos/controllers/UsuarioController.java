package com.senai.backend.equipamentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.equipamentos.models.Usuario;
import com.senai.backend.equipamentos.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired 
    private UsuarioService usuarioService;

    @GetMapping("/contar-usuarios")
    public Long contarUsuarios() {
        return usuarioService.contarUsuario();
    }

    @GetMapping("/buscar-usuario/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping("/listar-usuarios")
    public List<Usuario> listarUsuario() {
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("/deletar-usuario/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        if (usuarioService.deletarUsuario(id)) {
            return "Usuario deletado com sucesso!";
        }
        return "Usuario não encontrado!";
    }

    @PostMapping("/cadastrar-usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

        @PostMapping("/login")
    public Usuario fazerLogin(@RequestBody Usuario usuario) {
        return usuarioService.fazerLogin(
            usuario.getEmail(),
            usuario.getSenha()
        );
    }

}
