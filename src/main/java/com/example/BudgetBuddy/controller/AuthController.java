package com.example.BudgetBuddy.controller;

import com.example.BudgetBuddy.dto.AuthRequest;
import com.example.BudgetBuddy.dto.RegisterRequest;
import com.example.BudgetBuddy.repository.UserRepository;
import com.example.BudgetBuddy.security.JwtUtils;
import com.example.BudgetBuddy.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest Areq){
        return ResponseEntity.ok(userService.login(Areq));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest Rreq){
        return ResponseEntity.ok(userService.register(Rreq));
    }
}
