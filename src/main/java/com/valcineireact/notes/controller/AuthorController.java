package com.valcineireact.notes.controller;

import com.valcineireact.notes.entity.Author;
import com.valcineireact.notes.repositories.AuthorRepository;
import com.valcineireact.notes.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
@CrossOrigin(origins = "*")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        Author author = authorService.findById(id);

        return ResponseEntity.ok().body(author);
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author obj){
        Author newAuthor = authorService.create(obj);

        return ResponseEntity.ok().body(newAuthor);
    }

    @GetMapping
    public ResponseEntity<List<Author>> listAll(){
        return ResponseEntity.ok().body(authorService.listAll());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
