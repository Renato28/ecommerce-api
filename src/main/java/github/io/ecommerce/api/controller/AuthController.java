package github.io.ecommerce.api.controller;

import github.io.ecommerce.api.request.LoginRequest;
import github.io.ecommerce.api.response.TokenResponse;
import github.io.ecommerce.application.command.LoginCommand;
import github.io.ecommerce.application.handler.LoginHandler;
import github.io.ecommerce.infraestructure.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginHandler loginHandler;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        var command = new LoginCommand(request.username(), request.password());
        var token = loginHandler.handle(command);
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
