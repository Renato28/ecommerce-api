package github.io.ecommerce.domain.model;

import github.io.ecommerce.application.command.CreateProductCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Product {

    private UUID id;
    private String name;
    private BigDecimal price;
    private int quantity;

    public Product(CreateProductCommand command) {
        this.name = command.name();
        this.price = command.price();
        this.quantity = command.quantity();
    }
}
