package com.crayon.notes.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.crayon.notes.Exception.ResourceNotFoundException;
import com.crayon.notes.entity.Notes;
import com.crayon.notes.entity.Tag;
@Component
public interface NotesService {
	public Notes createNotes(Notes note) throws ResourceNotFoundException;
	public Tag createTags(Tag note);
	public List<Notes> getNoteswithTag(String t1,String t2);
	public List<Notes> getNotes();
	public Notes updateNotes(Notes note) throws ResourceNotFoundException;
	public Notes addTag(Long id, Tag tag) throws ResourceNotFoundException;
}
