package github.io.ecommerce.infraestructure.persistence.repository;

import github.io.ecommerce.domain.model.User;
import github.io.ecommerce.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository repository;

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username).map(entity ->
                new User(entity.getId(),
                        entity.getUsername(),
                        entity.getPassword(),
                        entity.getRole()));
    }
}
