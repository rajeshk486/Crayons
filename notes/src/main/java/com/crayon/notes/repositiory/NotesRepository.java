package com.crayon.notes.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.crayon.notes.entity.Notes;
import com.crayon.notes.entity.Tag;
@Component

public interface NotesRepository extends JpaRepository<Notes, Long>{
	List<Notes> findByTag(Tag tag);

}