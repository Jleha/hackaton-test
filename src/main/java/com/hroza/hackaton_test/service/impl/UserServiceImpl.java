package com.hroza.hackaton_test.service.impl;

import com.hroza.hackaton_test.entity.User;
import com.hroza.hackaton_test.repo.UserRepository;
import com.hroza.hackaton_test.request.UserLoginRequest;
import com.hroza.hackaton_test.request.UserProfileUpdateRequest;
import com.hroza.hackaton_test.request.UserRegistrationRequest;
import com.hroza.hackaton_test.service.UserService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserRegistrationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        userRepository.save(user);
    }

    public void loginUser(UserLoginRequest request) {
    }

    @SneakyThrows
    public void updateUserProfile(Long userId, UserProfileUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        userRepository.save(user);
    }


    @SneakyThrows
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
    }
}
