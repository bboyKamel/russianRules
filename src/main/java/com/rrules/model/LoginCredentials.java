package com.rrules.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginCredentials {
    private String username;
    private String pass;

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }   
}
