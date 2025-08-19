package com.example.BudgetBuddy.controller;

import com.example.BudgetBuddy.dto.auth.AuthRequest;
import com.example.BudgetBuddy.dto.auth.RegisterRequest;
import com.example.BudgetBuddy.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public ResponseEntity<?> getAllUsers() {
        return ok(userService.getAllUsers());
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
