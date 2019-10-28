package br.ufcg.psoft.ajude.security;

import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userService.findByEmail(email);

        if (user == null) {
            throw new BadCredentialsException("Não existe usuário com esse email");
        }
        if (user.getPassword().equals(password)) {
            return new UsernamePasswordAuthenticationToken(email, password);
        }
        return null;
    }
}
