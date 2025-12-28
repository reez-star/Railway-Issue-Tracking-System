package com.example.railwaystationissuetrackingsystem.controller;

import com.example.railwaystationissuetrackingsystem.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

       
        if ("admin".equals(username) && "admin123".equals(password)) {
            String token = JwtUtil.generateToken(username, "ADMIN");

            Map<String, String> response = new HashMap<>();
            response.put("role", "ADMIN");
            response.put("token", token);

            return ResponseEntity.ok(response);
        }

        
        return ResponseEntity.status(401).body("Access Denied: Only Administrators can generate security tokens.");
    }
}