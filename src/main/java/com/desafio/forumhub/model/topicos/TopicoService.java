package com.desafio.forumhub.model.topicos;

import com.desafio.forumhub.infra.exception.NotFoundException;
import com.desafio.forumhub.infra.exception.RegisterException;
import com.desafio.forumhub.model.curso.Curso;
import com.desafio.forumhub.model.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class TopicoService {
    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public DadosTopico registrar(DadosRegistroTopico dados, Usuario usuario) {
        Optional<Topico> optionalTopico = repository.findByTituloAndMensagem(dados.titulo(), dados.mensagem());

        if(optionalTopico.isPresent()) {
            throw new RegisterException("Não é possivel registrar um topico com o mesmo titulo e mensagem");
        }
        Topico topico = repository.save(new Topico(dados, usuario));
        return new DadosTopico(topico);
    }

    public Page<DadosTopico> buscarTodos(Pageable pageable) {
        return repository.findAll(pageable).map(DadosTopico::new);
    }

    public DadosTopico buscar(Long id) {

        return new DadosTopico(this.buscarTopicoPeloId(id));
    }

    private Topico buscarTopicoPeloId(Long id) {
        Optional<Topico> optionalTopico = repository.findById(id);

        if(optionalTopico.isEmpty()) {
            throw new NotFoundException("Topico com esse id não encontrado");
        }
        return optionalTopico.get();
    }


    public DadosTopico atualizar(Long id, DadosAtualizacaoTopico dados, Usuario usuario) {
        Optional<Topico> optionalTopico = repository.findByTituloAndMensagem(dados.titulo(), dados.mensagem());

        if(optionalTopico.isPresent()) {
            throw new RegisterException("Não é possivel registrar um topico com o mesmo titulo e mensagem");
        }
        Topico topico = this.buscarTopicoPeloIdEUsuario(id,usuario);
        topico.atualizar(dados);

        return new DadosTopico((Topico) repository.save(topico));
    }

    public void deletar(Long id, Usuario usuario) {
        Topico topico = this.buscarTopicoPeloIdEUsuario(id,usuario);
        repository.deleteById(topico.getId());
    }

    private Topico buscarTopicoPeloIdEUsuario(Long id, Usuario usuario) {
        Optional<Topico> optionalTopico = repository.findByIdAndAutor(id,usuario);

        if(optionalTopico.isEmpty()) {
            throw new NotFoundException("Topico com esse id não encontrado");
        }
        return optionalTopico.get();
    }
}
