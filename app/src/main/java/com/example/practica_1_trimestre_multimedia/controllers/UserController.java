package com.example.practica_1_trimestre_multimedia.controllers;

import com.example.practica_1_trimestre_multimedia.models.User;

public class UserController {
    static User user;

    public static void createUser(String username, String email, String password) {
        user = new User(username, email, password);
    }

    public static User getUser() {
        return user;
    }

    public static void editUserPoints(int points) {
        user.setPoints(user.getPoints() + points);
    }

    public static void createUserLogin(String username, String email, String password) {
        user = new User(username, email, password);
    }

    public static void updateUserPassword(String password) {
        user.setPassword(password);
    }

    public static void updateUserEmail(String email) {
        user.setEmail(email);
    }
}
