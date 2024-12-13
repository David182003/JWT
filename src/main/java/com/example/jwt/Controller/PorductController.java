package com.example.jwt.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos")
public class PorductController {
    @GetMapping
    public ResponseEntity<?> obtenerProductos() {
        // Obtiene el nombre de usuario del contexto de seguridad actual
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // Construye la respuesta
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Bienvenido " + username);
        response.put("productos", List.of("Producto1", "Producto2", "Producto3"));
        return ResponseEntity.ok(response);
    }
}
