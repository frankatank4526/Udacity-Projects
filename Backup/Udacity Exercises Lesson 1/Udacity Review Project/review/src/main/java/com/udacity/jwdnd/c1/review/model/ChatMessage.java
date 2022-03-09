package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    private Integer messageId;
    private String username;
    private String message;


    public ChatMessage(Integer messageId, String username, String message){
        this.username = username;
        this.message = message;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
