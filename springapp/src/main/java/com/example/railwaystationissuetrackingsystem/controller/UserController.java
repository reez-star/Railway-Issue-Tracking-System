package com.example.railwaystationissuetrackingsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.railwaystationissuetrackingsystem.model.User;
import com.example.railwaystationissuetrackingsystem.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @GetMapping("/page/{page}/{size}")
    public Page<User> pagination(@PathVariable int page, @PathVariable int size) {
        return userService.getUsersWithPagination(page, size);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<?> getUsersByRole(@PathVariable String role) {
        List<User> users = userService.getUsersByRole(role);
        if (users.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No users found with role: " + role);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with email: " + email);
        return ResponseEntity.ok(user);
    }
}
