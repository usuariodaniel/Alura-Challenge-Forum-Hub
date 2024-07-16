package com.desafio.forumhub.model.topicos;

import com.desafio.forumhub.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository {
    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);

    Optional<Topico> findByIdAndAutor(Long id, Usuario autor);
}
