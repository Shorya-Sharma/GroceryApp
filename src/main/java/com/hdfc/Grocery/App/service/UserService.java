package com.hdfc.Grocery.App.service;

import com.hdfc.Grocery.App.dao.UserRepository;
import com.hdfc.Grocery.App.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        // Additional validation or logic can be added before saving to the repository
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        // Additional logic for updating a user
        // Fetch the user by ID, update necessary fields, and save
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userDetails.setId(userId);
            // Update user details with userDetails
            // For example: user.setName(userDetails.getName());
            return userRepository.save(userDetails);
        } else {
            // Handle user not found
            return null;
        }
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

