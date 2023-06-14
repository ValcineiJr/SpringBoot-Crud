package com.valcineireact.notes.service;

import com.valcineireact.notes.entity.Author;
import com.valcineireact.notes.entity.Note;
import com.valcineireact.notes.exceptions.ObjectNotFoundException;
import com.valcineireact.notes.repositories.AuthorRepository;
import com.valcineireact.notes.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Note findById(Long id){
        Optional<Note> note = noteRepository.findById(id);
        //return note.orElse(null);
        return note.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note update(Long id, Note obj) {
        Note newObj = findById(id);

        newObj.setContent(obj.getContent());
        newObj.setTitle(obj.getTitle());

        return noteRepository.save(newObj);
    }

    public Note create(Note obj) {
        obj.setId(null);
        Optional<Author> author = authorRepository.findById(obj.getAuthor().getId());


        if(author != null){
            obj.setAuthor(author.get());
        }

        return noteRepository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        noteRepository.deleteById(id);
    }
}
