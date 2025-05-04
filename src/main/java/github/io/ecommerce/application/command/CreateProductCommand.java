package github.io.ecommerce.application.command;

import java.math.BigDecimal;

public record CreateProductCommand(String name, BigDecimal price, int quantity){

}
