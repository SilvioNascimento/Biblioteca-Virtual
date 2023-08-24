package com.ufpb.biblioteca.controller;

import com.ufpb.biblioteca.livro.Livro;
import com.ufpb.biblioteca.repository.LivroRepository;
import com.ufpb.biblioteca.request.LivroRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity getAllBooks() {
        var listaLivros = repository.findAll();
        return ResponseEntity.ok(listaLivros); //Retorna todos os objetos do tipo Livro
    }

    // Mostra tudo sobre o livro especificado pelo id
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @GetMapping("/{id}")
//    public ResponseEntity getBookInId(@PathVariable String id) {
//        Optional<Livro> livro = repository.findById(id);
//        return ResponseEntity.ok(livro);
 //   }

    // Mostra tudo sobre o livro especificado pelo titulo
    @GetMapping("/{titulo}")
    public ResponseEntity getBookInTitulo(@PathVariable String titulo) {
        List<Livro> livroEncontrado = repository.findByTitulo(titulo);
        if(!livroEncontrado.isEmpty()) {
            return ResponseEntity.ok(livroEncontrado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity cadastrarLivro(@RequestBody @Valid LivroRequestDTO data) {
        Livro livroData = new Livro(data);
        repository.save(livroData);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    @Transactional
    public ResponseEntity atualizarLivro(@RequestBody @Valid LivroRequestDTO data) {
        Optional<Livro> opcionalLivro = repository.findById(data.id());
        if(opcionalLivro.isPresent()) {
            Livro livro = opcionalLivro.get();
            livro.setTitulo(data.titulo());
            livro.setAutor(data.autor());
            livro.setTipoTextual(data.tipo_textual());
            livro.setAnoPublicacao(data.ano_publicacao());
            livro.setCapaDoLivro(data.capa_do_livro());
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarLivro(@PathVariable String id) {
        Optional<Livro> livro = repository.findById(id);
        if(livro.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
