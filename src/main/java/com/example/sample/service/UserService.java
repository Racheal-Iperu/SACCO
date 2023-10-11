package com.example.sample.service;

import com.example.sample.model.User;
import com.example.sample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String email, String password) {
        // Check if a user with the provided username or email already exists
        if (userRepository.findByUsername(username) != null ||
                userRepository.findByEmail(email) != null) {
            throw new UserRegistrationException("Username or email already in use");
        }

        // Hash the password before storing

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);

        return userRepository.save(user);
    }
}
