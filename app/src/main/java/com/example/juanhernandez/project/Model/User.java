package com.example.juanhernandez.project.Model;

/**
 * Created by Daniel on 3/05/2018.
 */

public class User {
    private String Password;
    private String email;

    public User() {
    }

    public User(String password, String email) {
        Password = password;
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}