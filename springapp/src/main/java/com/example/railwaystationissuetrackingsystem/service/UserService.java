package com.example.railwaystationissuetrackingsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.example.railwaystationissuetrackingsystem.model.User;
import com.example.railwaystationissuetrackingsystem.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        User existing = userRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setFullName(user.getFullName());
        existing.setRole(user.getRole());

        return userRepo.save(existing);
    }

    public Page<User> getUsersWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("userId"));
        return userRepo.findAll(pageable);
    }

    public List<User> getUsersByRole(String role) {
        return userRepo.findAll()
                .stream()
                .filter(u -> u.getRole().equals(role))
                .toList();
    }

    public User getUserByEmail(String email) {
        return userRepo.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
