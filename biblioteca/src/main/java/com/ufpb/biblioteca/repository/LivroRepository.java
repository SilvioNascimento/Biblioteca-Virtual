package com.ufpb.biblioteca.repository;

import com.ufpb.biblioteca.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface LivroRepository extends JpaRepository<Livro, String> {
    List<Livro> findByTitulo(String titulo);
}
