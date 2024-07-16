package com.desafio.forumhub.controller;

import com.desafio.forumhub.model.usuario.DadosAutenticacao;
import com.desafio.forumhub.model.usuario.DadosRegistroUsuario;
import com.desafio.forumhub.model.usuario.Usuario;
import com.desafio.forumhub.model.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity<?> adicionarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = service.salvar(usuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }
}
