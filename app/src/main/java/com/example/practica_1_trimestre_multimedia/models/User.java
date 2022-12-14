package com.example.practica_1_trimestre_multimedia.models;

public class User {
    private String username;
    private String email;
    private String password;
    private int points;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.points = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
