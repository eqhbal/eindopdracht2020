package com.kapper.demo.repository;

import com.kapper.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Collection<User> findAllByUsername(String username);
    Optional<User> findByUsername(String username);
}
