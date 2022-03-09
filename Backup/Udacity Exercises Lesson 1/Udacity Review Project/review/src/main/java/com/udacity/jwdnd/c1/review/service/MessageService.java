package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public List<ChatMessage> getChatMessages(){

        return messageMapper.getMessages();
    }
    public void addMessageSay(ChatMessage message){
        messageMapper.insertMessage(message);
    }
    public void addMessageShout(ChatMessage message){
        message.setMessage(message.getMessage().toUpperCase());
        messageMapper.insertMessage(message);
    }
    public void addMessageWhisper(ChatMessage message){
        message.setMessage(message.getMessage().toLowerCase());
        messageMapper.insertMessage(message);
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
