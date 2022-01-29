package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {

    NoteService noteService;
    UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @PostMapping("/home/note")
    public String postData(@ModelAttribute("noteForm") NoteForm noteForm, Authentication authentication, Model model) {
        //add errors for each case

        if (noteForm.getNoteTitle() != "" && noteForm.getNoteDescription() != "") {
            if(noteForm.getNoteId() == null) {
                this.noteService.insertNote(noteForm, this.userService.getUser(authentication.getName()).getUserId());
                noteForm.setNoteTitle("");
                noteForm.setNoteDescription("");
                return "redirect:/result?success=true&errorMsg=0";
            }
            else{
                if(this.noteService.findNote(noteForm.getNoteId()).getUserId() == this.userService.getUser(authentication.getName()).getUserId()) {
                    this.noteService.updateNote(noteForm);
                    noteForm.setNoteTitle("");
                    noteForm.setNoteDescription("");
                    return "redirect:/result?success=true&errorMsg=0";
                }
                else{
                    return "redirect:/result?success=false&errorMsg=2";
                }
            }
        }
        else{
            return "redirect:/result?success=false&errorMsg=3";
        }
    }
    @GetMapping("/home/note/delete/{noteId}")
    public String deleteNote(Model model, Authentication authentication, @PathVariable int noteId){
        if(this.userService.getUser(authentication.getName()).getUserId() == this.noteService.findNote(noteId).getUserId()) {
            this.noteService.deleteNote(noteId);
            return "redirect:/result?success=true&errorMsg=0";
        }
        else{
            return "redirect:/result?success=false&errorMsg=2";
        }
    }
}
