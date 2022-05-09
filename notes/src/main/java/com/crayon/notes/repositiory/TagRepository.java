package com.crayon.notes.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.crayon.notes.entity.Tag;

//@Repository
@Component
public interface TagRepository extends JpaRepository<Tag, Long>{

	Tag findByName(String name);

}
