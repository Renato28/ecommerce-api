package github.io.ecommerce.application.handler;

import github.io.ecommerce.application.command.LoginCommand;
import github.io.ecommerce.domain.exception.UserNotFoundException;
import github.io.ecommerce.domain.model.User;
import github.io.ecommerce.domain.repository.UserRepository;
import github.io.ecommerce.domain.service.UserService;
import github.io.ecommerce.infraestructure.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginHandler {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final UserService userService;

    private static final String USER_NOT_FOUND = "Usuário não encontrado";

    public String handle(LoginCommand command) {
        User user = userRepository.findByUsername(command.username())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        if (!userService.verifyPassword(user, command.password())) {
            throw new BadCredentialsException("Usuário ou senha inválida");
        }

        return jwtService.generateToken(user.getUsername(), user.getRole());
    }
}
