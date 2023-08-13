package com.ufpb.biblioteca.livro;


import com.ufpb.biblioteca.request.LivroRequestDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "livros")
@Entity(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String titulo;
    private String autor;
    private String tipo_textual;
    private Integer ano_publicacao;
    private String capa_do_livro;

    public Livro(String id, String titulo, String autor, String tipo_textual, Integer ano_publicacao,
                 String capa_do_livro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.tipo_textual = tipo_textual;
        this.ano_publicacao = ano_publicacao;
        this.capa_do_livro = capa_do_livro;
    }

    public Livro(LivroRequestDTO data) {
        this.titulo = data.titulo();
        this.autor = data.autor();
        this.tipo_textual = data.tipo_textual();
        this.ano_publicacao = data.ano_publicacao();
        this.capa_do_livro = data.capa_do_livro();
    }

    public Livro() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipoTextual() {
        return tipo_textual;
    }

    public void setTipoTextual(String tipo_textual) {
        this.tipo_textual = tipo_textual;
    }

    public Integer getAnoPublicacao() {
        return ano_publicacao;
    }

    public void setAnoPublicacao(Integer ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public String getCapaDoLivro() {
        return capa_do_livro;
    }

    public void setCapaDoLivro(String capa_do_livro) {
        this.capa_do_livro = capa_do_livro;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
