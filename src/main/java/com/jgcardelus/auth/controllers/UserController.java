package com.jgcardelus.auth.controllers;

import com.jgcardelus.auth.model.UserModel;
import com.jgcardelus.auth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserModel>> retrieveAll(@AuthenticationPrincipal User user) {
        System.out.println(user.getUsername());
        return ResponseEntity.ok().body(service.retrieveAll());
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        UserModel newUser = service.create(user);
        return ResponseEntity.ok().body(newUser);
    }
}
