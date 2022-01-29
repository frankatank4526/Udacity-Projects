package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mappers.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public List<Note> getAllNotes(int userId){
        return this.noteMapper.getAllNotes(userId);
    }

    public Note findNote(int noteId){
        return this.noteMapper.findNote(noteId);
    }

    public void insertNote(NoteForm noteForm, Integer userId) {
        Note noteToAdd = new Note(null, noteForm.getNoteTitle(), noteForm.getNoteDescription(), userId);
        this.noteMapper.insertNote(noteToAdd);
    }

    public void updateNote(NoteForm noteForm){
        this.noteMapper.updateNote(noteForm.getNoteId(), noteForm.getNoteTitle(), noteForm.getNoteDescription());
    }
    public void deleteNote(int noteId){
        this.noteMapper.deleteNote(noteId);
    }
}
