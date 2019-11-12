package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.exceptions.email.EmailInvalidException;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.service.email.EmailService;
import br.ufcg.psoft.ajude.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Controller de usúarios")
@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @ApiOperation(value = "Cadastra um novo usuário")
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        try{
            this.emailService.sendMail(user);
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
