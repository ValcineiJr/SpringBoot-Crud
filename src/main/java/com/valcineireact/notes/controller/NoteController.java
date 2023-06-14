package com.valcineireact.notes.controller;

import com.valcineireact.notes.entity.Note;
import com.valcineireact.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Note> findById(@PathVariable Long id){
        Note obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Note>> listAll(){
        List<Note> notes = service.findAll();
        return ResponseEntity.ok().body(notes);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Note>  update(@PathVariable Long id, @RequestBody Note obj){
        Note newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Note> create(@RequestBody Note obj){
        Note newObj = service.create(obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
