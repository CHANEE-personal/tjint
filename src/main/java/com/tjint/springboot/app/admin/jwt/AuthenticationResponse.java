package com.tjint.springboot.app.admin.jwt;

import lombok.Getter;

@Getter
public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}
