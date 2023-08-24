package com.ufpb.biblioteca.repository;

import com.ufpb.biblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, String> {
    List<Livro> findByTitulo(String titulo);
}
