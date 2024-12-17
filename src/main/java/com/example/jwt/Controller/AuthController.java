package com.example.jwt.Controller;

import com.example.jwt.Jwt.JwtUtil;
import com.example.jwt.Model.User;
import com.example.jwt.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // inject auth service
    @Autowired
    private AuthService authService;

    // inject jwtUtil
    @Autowired
    private JwtUtil jwtUtil;

    // method register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User usuario) {
        User registrado = authService.registrar(usuario);
        return ResponseEntity.ok(registrado);
    }

    // method login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User credenciales) {
        User usuario = authService.validarCredenciales(credenciales.getUsername(), credenciales.getPassword());
        String token = jwtUtil.generateToken(usuario.getUsername());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
