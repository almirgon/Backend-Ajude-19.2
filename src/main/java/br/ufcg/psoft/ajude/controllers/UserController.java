package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.exceptions.email.EmailInvalidException;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.service.email.EmailService;
import br.ufcg.psoft.ajude.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        try{
            this.emailService.sendMail(user.getEmail());
        }catch (RuntimeException e){
            throw new EmailInvalidException("Email inválido");
        }
        return new ResponseEntity<User>(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email){
        return new ResponseEntity<User>(this.userService.findByEmail(email), HttpStatus.OK);
    }


}
