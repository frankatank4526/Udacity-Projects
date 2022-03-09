package com.udacity.jwdnd.c1.review.controllers;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ChatController {
    MessageService messageService;

    public ChatController(MessageService messageService){
        this.messageService = messageService;
    }
    @GetMapping("/chat")
    public String getChatMessages(@ModelAttribute("chatForm") ChatForm chatForm, Model model){

        model.addAttribute("chatMessages", messageService.getChatMessages());
        return "chat";
    }
    @PostMapping("/chat")
    public String postChatMessages(@RequestParam("testField") String testField, @ModelAttribute("chatForm") ChatForm chatForm, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if(chatForm.getMessageType().equals("say")) {
            messageService.addMessageSay(new ChatMessage(null, username, chatForm.getMessage()));
        }
        else if(chatForm.getMessageType().equals("shout")){
            messageService.addMessageShout(new ChatMessage(null, username, chatForm.getMessage()));
        }
        else{
            messageService.addMessageWhisper(new ChatMessage(null, username, chatForm.getMessage()));
        }
        model.addAttribute("chatMessages", messageService.getChatMessages());
        model.addAttribute("testField", testField);
        return "chat";
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
