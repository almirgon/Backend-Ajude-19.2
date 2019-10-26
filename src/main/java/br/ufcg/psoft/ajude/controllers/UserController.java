package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.exceptions.email.EmailInvalidException;
import br.ufcg.psoft.ajude.exceptions.password.PasswordInvalidException;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new PasswordInvalidException("Senha inválida");
        }
        return new ResponseEntity<User>(this.userService.createUser(user), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("email") String email) {
        if (userService.findByEmail(email).getEmail() == null || userService.findByEmail(email).getEmail().isEmpty()) {
            throw new EmailInvalidException("Email inválido");
        }
        userService.deleteByEmail(email);
        return new ResponseEntity(HttpStatus.OK);

    }

}
