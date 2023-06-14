package com.valcineireact.notes;

import com.valcineireact.notes.entity.Note;
import com.valcineireact.notes.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class NotesApplication implements CommandLineRunner {

	@Autowired
	private NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		Note n1 = new Note(null, "teste", "Ronaldo é maneiro");
		Note n2 = new Note(null, "teste2", "Ronaldo é maneiro 2");

		noteRepository.saveAll(Arrays.asList(n1, n2)); */
	}
}
