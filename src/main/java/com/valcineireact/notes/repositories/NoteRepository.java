package com.valcineireact.notes.repositories;

import com.valcineireact.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


    @Query(value = "SELECT  n.id, n.content, n.title, n.author_id,  FROM NOTE n INNER JOIN AUTHOR a ON a.id = n.author_id WHERE n.author_id = ?1", nativeQuery = true)
    List<Note> findAll(Long id);
}
