package com.desafio.forumhub.model.topicos;

import jakarta.validation.constraints.NotBlank;

public record DadosRegistroTopico(
        @NotBlank
        String mensagem,
        @NotBlank
        String curso,
        @NotBlank
        String titulo
) {
}
