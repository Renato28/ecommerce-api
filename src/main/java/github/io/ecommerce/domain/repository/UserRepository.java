package github.io.ecommerce.domain.repository;

import github.io.ecommerce.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}
