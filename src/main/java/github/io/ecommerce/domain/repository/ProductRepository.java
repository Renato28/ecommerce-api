package github.io.ecommerce.domain.repository;

import github.io.ecommerce.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    void save(Product product);
    Optional<Product> findById(UUID id);
    List<Product> findAll();
}
