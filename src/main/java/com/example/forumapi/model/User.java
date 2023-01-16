package com.example.forumapi.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private int nrOfMessages;
    private int nrOfTopics;

    public User(int id, String username, String password, String email, int nrOfMessages, int nrOfTopics) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nrOfMessages = nrOfMessages;
        this.nrOfTopics = nrOfTopics;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNrOfMessages() {
        return nrOfMessages;
    }

    public void setNrOfMessages(int nrOfMessages) {
        this.nrOfMessages = nrOfMessages;
    }

    public int getNrOfTopics() {
        return nrOfTopics;
    }

    public void setNrOfTopics(int nrOfTopics) {
        this.nrOfTopics = nrOfTopics;
    }
}
