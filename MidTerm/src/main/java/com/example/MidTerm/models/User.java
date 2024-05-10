package com.example.MidTerm.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int code;
    private  String username;
    private  String email;
    private  String password;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
}
