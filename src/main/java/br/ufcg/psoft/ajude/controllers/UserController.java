package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<User>(this.userService.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String email){
        return new ResponseEntity<User>(this.userService.findByEmail(email), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List users = this.userService.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable String email) {
        userService.deleteByEmail(email);
        return new ResponseEntity(HttpStatus.OK);

    }

}
