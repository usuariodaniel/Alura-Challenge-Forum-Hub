package com.desafio.forumhub.model.topicos;

import com.desafio.forumhub.model.curso.Curso;
import com.desafio.forumhub.model.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Curso curso, Usuario autor) {
    public DadosTopico (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriação(), topico.getCurso(), topico.getAutor());
    }
}
