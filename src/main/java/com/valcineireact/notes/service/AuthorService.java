package com.valcineireact.notes.service;

import com.valcineireact.notes.entity.Author;
import com.valcineireact.notes.exceptions.ObjectNotFoundException;
import com.valcineireact.notes.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findById(Long id){
        Optional<Author> author = authorRepository.findById(id);
        return author.orElseThrow(() -> new ObjectNotFoundException("Author não encontrado"));
    }

    public List<Author> listAll(){
        return authorRepository.findAll();
    }

    public Author create(Author obj) {
        obj.setId(null);
        return authorRepository.save(obj);
    }


    public void delete( Long id) {
        findById(id);
        authorRepository.deleteById(id);
    }
}
