package com.desafio.forumhub.model.usuario;

import com.desafio.forumhub.infra.exception.RegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario salvar(Usuario usuario) {
        String hash = passwordEncoder.encode(usuario.getPassword());
        usuario.setSenha(hash);
        return repository.save(usuario);
    }
}
