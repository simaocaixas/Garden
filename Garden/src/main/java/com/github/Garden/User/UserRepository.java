package com.github.Garden.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.github.Garden.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
