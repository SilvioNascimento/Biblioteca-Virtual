package com.ufpb.biblioteca.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LivroNotFoundException {

    // Lançará uma exceção uma vez que não encontra um valor pedido na API
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404() {
        return ResponseEntity.badRequest().body("Dado não encontrado");
    }
}
