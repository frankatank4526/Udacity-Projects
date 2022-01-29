package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    FileService fileService;
    NoteService noteService;
    CredentialService credentialService;
    UserService userService;

    public HomeController(FileService fileService, NoteService noteService, CredentialService credentialService, UserService userService) {
        this.fileService = fileService;
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getAll(Model model , Authentication authentication, @ModelAttribute ("noteForm") NoteForm noteForm, EncryptionService encryptionService, @ModelAttribute("credentialForm") CredentialForm credentialForm){
        model.addAttribute("encryptionService", encryptionService);
        model.addAttribute("files", this.fileService.getFiles(this.userService.getUser(authentication.getName()).getUserId()));
        model.addAttribute("notes", this.noteService.getAllNotes(this.userService.getUser(authentication.getName()).getUserId()));
        model.addAttribute("credentials", this.credentialService.getAllCredentials(this.userService.getUser(authentication.getName()).getUserId()));
        return "home";
    }
    @PostMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }


}
