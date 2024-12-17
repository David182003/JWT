package com.example.jwt.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public ResponseEntity<?> obtenerProductos() {
        // Gets the username of the current security context
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Bienvenido " + username);
        return ResponseEntity.ok(response);
    }
}
