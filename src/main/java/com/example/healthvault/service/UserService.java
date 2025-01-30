package com.example.healthvault.service;

import com.example.healthvault.dto.UserRegistrationDTO;
import com.example.healthvault.entity.User;
import com.example.healthvault.exceptions.EmailAlreadyExistException;
import com.example.healthvault.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(UserRegistrationDTO userRegistrationDTO) {

        if (userRepository.existsByEmail(userRegistrationDTO.getEmail())) {
            throw new EmailAlreadyExistException("User with this email already exists.");
        }

        User user = new User();
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

        return userRepository.save(user);
    }
}