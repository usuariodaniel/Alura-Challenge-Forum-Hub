package com.desafio.forumhub.controller;

import com.desafio.forumhub.model.topicos.DadosAtualizacaoTopico;
import com.desafio.forumhub.model.topicos.DadosRegistroTopico;
import com.desafio.forumhub.model.topicos.DadosTopico;
import com.desafio.forumhub.model.topicos.TopicoService;
import com.desafio.forumhub.model.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosTopico> registrar(@Valid @RequestBody DadosRegistroTopico dados, UriComponentsBuilder builder,
                                                 @AuthenticationPrincipal Usuario usuario) {
        DadosTopico dadosTopico = service.registrar(dados, usuario);
        URI uri = builder.path("/topicos/{id}").buildAndExpand(dadosTopico.id()).toUri();
        return ResponseEntity.created(uri).body(dadosTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosTopico>> buscarTodos(@PageableDefault(size = 10,sort = {"dataCriacao"},direction = Sort.Direction.ASC)
                                                         Pageable pageable) {
        return ResponseEntity.ok(service.buscarTodos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosTopico> buscarPeloId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosTopico> atualizar(@PathVariable Long id, @Valid @RequestBody DadosAtualizacaoTopico dados,
                                                 @AuthenticationPrincipal Usuario usuario) {
        return ResponseEntity.ok(service.atualizar(id,dados,usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id, @AuthenticationPrincipal Usuario usuario) {
        service.deletar(id,usuario);
        return ResponseEntity.ok().build();
    }
}
