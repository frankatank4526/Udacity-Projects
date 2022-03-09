package com.example.demo;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    List<String> messages = new ArrayList<>();
    public List<String> getMessages() {
        return messages;
    }
    public void addMessage(String message) {
        messages.add(message);
    }
    /*
    @PostConstruct
    public void postConstruct(){
        this.messages = new ArrayList<>();
    }
     */
}
