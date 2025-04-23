package com.microblogging.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microblogging.backend.models.User;
import com.microblogging.backend.repositories.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        existingUser.setAlias(user.getAlias());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
}
