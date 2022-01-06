package com.udacity.jwdnd.c1.review;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    List<ChatMessage> chatMessages = new ArrayList<>();

    public List<ChatMessage> getChatMessages(){
        return chatMessages;
    }
    public void addMessage(ChatMessage message){
        chatMessages.add(message);
    }
/*
    public MessageService(String message){
        this.message = message;
    }

    public String uppercase(){
        return this.message.toUpperCase();
    }
    public String lowercase(){
        return this.message.toLowerCase();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }

     */
}
