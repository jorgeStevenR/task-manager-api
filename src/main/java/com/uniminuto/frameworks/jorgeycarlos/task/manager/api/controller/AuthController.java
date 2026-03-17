package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.controller;

import org.springframework.web.bind.annotation.*;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.LoginRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.LoginResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO request) {
        return authService.login(request);
    }
}