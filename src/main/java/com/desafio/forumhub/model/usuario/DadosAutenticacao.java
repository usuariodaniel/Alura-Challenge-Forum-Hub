package com.desafio.forumhub.model.usuario;

public record DadosAutenticacao(Long id, String nome, String senha, String email) {

    public DadosAutenticacao(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
