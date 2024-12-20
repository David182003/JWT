package com.example.jwt.Service;

import com.example.jwt.Model.User;
import com.example.jwt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // inject User Repository
    @Autowired
    private UserRepository userRepository;

    // inject PasswordEncoder
    @Autowired
    private PasswordEncoder passwordEncoder;

    // method register
    public User registrar(User usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return userRepository.save(usuario);
    }

    //method validate credentials
    public User validarCredenciales(String username, String password) {
        User usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }
        return usuario;
    }
}
