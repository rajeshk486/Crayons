package com.crayon.notes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crayon.notes.Exception.ResourceNotFoundException;
import com.crayon.notes.entity.Notes;
import com.crayon.notes.entity.Tag;
import com.crayon.notes.service.NotesService;
import com.sun.istack.NotNull;

@RestController
public class NotesController {

	@Autowired
	NotesService noteService;

	@GetMapping("/health")
	public String health() {
		return "Success";
	}

	@PostMapping("/note")
	public ResponseEntity<Notes> createNotes(@RequestBody @NotNull Notes note) throws ResourceNotFoundException {

		return ResponseEntity.ok(noteService.createNotes(note));
	}

	@PutMapping("/note/{id}")
	public ResponseEntity<Notes> updateeNotes(@PathVariable Long id,@RequestBody @NotNull Tag tag) throws ResourceNotFoundException {
		
		return ResponseEntity.ok(noteService.addTag(id,tag));
	}

	@PostMapping("/tag")
	public ResponseEntity<Tag> createTag(@RequestBody @NotNull Tag tag) {

		return ResponseEntity.ok(noteService.createTags(tag));
	}

	@GetMapping
	public ResponseEntity<List<Notes>> getNotes() {
		return ResponseEntity.ok(noteService.getNotes());

	}

	@GetMapping("/notes")
	public ResponseEntity<List<Notes>> getTaggedNotes(@RequestParam String c1, @RequestParam String c2) {
		return ResponseEntity.ok(noteService.getNoteswithTag(c1, c2));

	}
}
