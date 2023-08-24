package com.ufpb.biblioteca.request;

import com.ufpb.biblioteca.entity.Livro;

public record LivroResponseDTO(String id, String titulo, String autor, String tipo_textual,
                               Integer ano_publicacao, String capa_do_livro) {
    public LivroResponseDTO(Livro livro) {
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getTipoTextual(), livro.getAnoPublicacao(), livro.getCapaDoLivro());
    }
}