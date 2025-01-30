package com.example.healthvault.service;

import com.example.healthvault.dto.LoginRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
}
