package com.ufpb.biblioteca.livro.repository;

import com.ufpb.biblioteca.livro.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, String> {
    List<Livro> findByTitulo(String titulo);
}
