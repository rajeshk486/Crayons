package com.crayon.notes.entity;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;
@Entity(name="notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notes_id",nullable = false)
    private long notesId;
    
    @Column(name = "content")
    @NotNull
    private String content;
    
    @Column(name = "note_id")
    private String noteId;
    
   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="NOTES_TAG", 
    joinColumns=@JoinColumn(name="notes_id"),
    inverseJoinColumns=@JoinColumn(name="tag_id"))   
    private Set<Tag> tag;

    @CreationTimestamp
	@Column( updatable = false)
	private LocalDateTime createdOn;
	
    @UpdateTimestamp
	@Column
	private LocalDateTime updatedOn;

    
	public long getNotesId() {
		return notesId;
	}

	public void setNotesId(long notesId) {
		this.notesId = notesId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public Set<Tag> getTag() {
		return tag;
	}

	public void setTag(Set<Tag> tag) {
		this.tag = tag;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	
   
}
