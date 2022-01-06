package com.udacity.jwdnd.c1.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {
    MessageService messageService;

    public ChatController(MessageService messageService){
        this.messageService = messageService;
    }
    @GetMapping("/chat")
    public String getChatMessages(@ModelAttribute ChatForm ChatForm, Model model){
        if(messageService.chatMessages.isEmpty()){
            messageService.addMessage(new ChatMessage("Example Username", "Example message"));
            model.addAttribute("chatMessages", messageService.getChatMessages());
            return "chat";
        }
        else{
            model.addAttribute("chatMessages", messageService.getChatMessages());
            return "chat";
        }
    }
    @PostMapping("/chat")
    public String postChatMessages(@ModelAttribute ChatForm ChatForm, Model model){
        messageService.addMessage(new ChatMessage(ChatForm.getUsername(), ChatForm.getMessage()));
        model.addAttribute("chatMessages", messageService.getChatMessages());
        return "chat";
    }

}
