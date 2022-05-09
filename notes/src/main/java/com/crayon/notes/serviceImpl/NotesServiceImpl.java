package com.crayon.notes.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crayon.notes.Exception.ResourceNotFoundException;
import com.crayon.notes.entity.Notes;
import com.crayon.notes.entity.Tag;
import com.crayon.notes.repositiory.NotesRepository;
import com.crayon.notes.repositiory.TagRepository;
import com.crayon.notes.service.NotesService;
@Service
public class NotesServiceImpl implements NotesService{
	@Autowired
	NotesRepository notesRepository;
	@Autowired
	TagRepository tagRepository;
	Notes noteObj;
	@Override
	public Notes createNotes(Notes note) throws ResourceNotFoundException {
/*		if(note.getTag().size()>5)
			throw new ResourceNotFoundException("not more than 5 Tag allowed for a NOTE");
*/
		return notesRepository.save(note);
		 
	}
	
	
	@Override
	public Notes updateNotes(Notes note) throws ResourceNotFoundException {
		if(notesRepository.getById(note.getNotesId()) == null || (notesRepository.getById(note.getNotesId()).getTag().size()+note.getTag().size())>=6)
			throw new ResourceNotFoundException("Note not updated: Tag count is more or note not available");
		
		return notesRepository.save(note);
		 
	}
	
	@Override
	public Notes addTag(Long id,Tag tag) throws ResourceNotFoundException
	{
		Notes note= notesRepository.findById(id).orElse(null);
		
		if(note==null)
			throw new ResourceNotFoundException(" given ID not available in notes");
		
			Tag t=tagRepository.findById(tag.getId()).orElse(null);
			if(t!=null && note.getTag().size()<5)
				{
				Set<Tag> tagSet= note.getTag();
				tagSet.add(t);
				note.setTag(tagSet);
				notesRepository.save(note);
				
				}
			else
				 new ResourceNotFoundException(" Tags limit reached or tag Id is not avaialble.");
		
		return note;
		
	}

	@Override
	public Tag createTags(Tag tag) {
if(Objects.isNull(tagRepository.findByName(tag.getName())))
	
			return tagRepository.save(tag);
else
	return tagRepository.findByName(tag.getName());
	}

	@Override
	public List<Notes> getNoteswithTag(String t1, String t2) {
		List<Notes> tagNotes=new ArrayList<>();
		if(t1.isEmpty() && t2.isEmpty())
			return notesRepository.findAll();
		Tag tag1=Objects.nonNull(tagRepository.findByName(t1))?tagRepository.findByName(t1):null;
		Tag tag2=Objects.nonNull(tagRepository.findByName(t2))?tagRepository.findByName(t2):null;
		if(tag1!=null)
		{
			
		tagNotes.addAll(notesRepository.findByTag(tag1));
		}
		if(tag2!=null)
		tagNotes.addAll(notesRepository.findByTag(tag2));
		return tagNotes;
	}

	@Override
	public List<Notes> getNotes() {
		return notesRepository.findAll();
	}

}
