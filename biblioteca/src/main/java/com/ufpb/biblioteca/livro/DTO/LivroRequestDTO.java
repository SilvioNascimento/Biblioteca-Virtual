package com.ufpb.biblioteca.livro.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequestDTO(String id,
                              @NotBlank
                              String titulo,
                              @NotBlank
                              String autor,
                              @NotBlank
                              String tipo_textual,
                              @NotNull
                              Integer ano_publicacao,
                              String capa_do_livro) {

}
