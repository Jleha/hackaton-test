package com.hroza.hackaton_test.controller;

import com.hroza.hackaton_test.request.UserLoginRequest;
import com.hroza.hackaton_test.request.UserProfileUpdateRequest;
import com.hroza.hackaton_test.request.UserRegistrationRequest;
import com.hroza.hackaton_test.service.UserService;
import com.hroza.hackaton_test.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserRegistrationRequest request) {
        userService.registerUser(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody UserLoginRequest request) {
        userService.loginUser(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserProfile(@PathVariable Long userId, @RequestBody UserProfileUpdateRequest request) {
        userService.updateUserProfile(userId, request);
        return ResponseEntity.ok().build();
    }
}

