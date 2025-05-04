package github.io.ecommerce.infraestructure.persistence.repository;

import github.io.ecommerce.domain.model.Product;
import github.io.ecommerce.domain.repository.ProductRepository;
import github.io.ecommerce.infraestructure.persistence.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final SpringDataProductRepository repository;

    @Override
    public void save(Product product) {
        ProductEntity entity = new ProductEntity(product);
        repository.save(entity);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return repository.findById(id).map(entity ->
                new Product(entity.getId(),
                        entity.getName(),
                        entity.getPrice(),
                        entity.getQuantity()));
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll()
                .stream()
                .map(entity ->
                new Product(entity.getId(),
                        entity.getName(),
                        entity.getPrice(),
                        entity.getQuantity()))
                .toList();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
