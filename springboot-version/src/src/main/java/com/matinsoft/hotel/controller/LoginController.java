package com.matinsoft.hotel.controller;

import org.springframework.web.bind.annotation.*;

import com.matinsoft.hotel.dto.LoginRequest;
import com.matinsoft.hotel.dto.LoginResponse;
import com.matinsoft.hotel.service.LoginService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService theLoginService) {
        this.loginService = theLoginService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}