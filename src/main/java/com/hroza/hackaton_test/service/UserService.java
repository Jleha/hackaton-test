package com.hroza.hackaton_test.service;

import com.hroza.hackaton_test.entity.User;
import com.hroza.hackaton_test.request.UserLoginRequest;
import com.hroza.hackaton_test.request.UserProfileUpdateRequest;
import com.hroza.hackaton_test.request.UserRegistrationRequest;

public interface UserService {

    public void registerUser(UserRegistrationRequest request);

    public void loginUser(UserLoginRequest request);

    public void updateUserProfile(Long userId, UserProfileUpdateRequest request);

    User getUserById(Long userId);
}
