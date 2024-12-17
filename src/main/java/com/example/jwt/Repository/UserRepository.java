package com.example.jwt.Repository;

import com.example.jwt.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // method username
    Optional<User> findByUsername(String username);
}
