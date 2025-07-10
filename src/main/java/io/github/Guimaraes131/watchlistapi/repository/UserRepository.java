package io.github.Guimaraes131.watchlistapi.repository;

import io.github.Guimaraes131.watchlistapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByLogin(String login);
}
