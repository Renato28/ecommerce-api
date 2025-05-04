package github.io.ecommerce.application.handler;

import github.io.ecommerce.application.command.CreateProductCommand;
import github.io.ecommerce.domain.model.Product;
import github.io.ecommerce.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductHandler {

    private final ProductRepository repository;

    public void handle(CreateProductCommand command) {
        Product product = new Product(command);
        repository.save(product);
    }
}
