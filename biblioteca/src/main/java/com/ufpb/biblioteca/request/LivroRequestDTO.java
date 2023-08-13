package com.ufpb.biblioteca.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

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
