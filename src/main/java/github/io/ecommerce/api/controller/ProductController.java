package github.io.ecommerce.api.controller;

import github.io.ecommerce.application.command.CreateProductCommand;
import github.io.ecommerce.application.handler.CreateProductHandler;
import github.io.ecommerce.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductHandler handler;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateProductCommand command) {
        handler.handle(command);
        return ResponseEntity.ok().build();
    }
}
