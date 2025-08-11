package com.example.BudgetBuddy.service;

import com.example.BudgetBuddy.dto.AuthRequest;
import com.example.BudgetBuddy.dto.RegisterRequest;
import com.example.BudgetBuddy.model.User;
import com.example.BudgetBuddy.repository.UserRepository;
import com.example.BudgetBuddy.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       AuthenticationManager authenticationManager,
                       JwtUtils jwtUtils,
                       PasswordEncoder passwordEncoder)  {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    public Map<String,String> login(AuthRequest Areq){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(Areq.getUsername(), Areq.getPassword()));
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        //Like this till we implement premium versions
        Map<String,Object> claims = Map.of(
                "roles", "ROLE_USER");

        String token= jwtUtils.generateToken(userDetails.getUsername(), claims);
        return Map.of("token", token);
    }

    public String register(RegisterRequest Rreq) {
        if (userRepository.findByUsername(Rreq.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User();
        user.setUsername(Rreq.getUsername());
        user.setEmail(Rreq.getEmail());
        user.setPassword(passwordEncoder.encode(Rreq.getPassword()));
        user.setAccounts(new ArrayList<>());
        user.setCategories(new ArrayList<>());

        userRepository.save(user);

        return "User registered successfully";
    }

}
