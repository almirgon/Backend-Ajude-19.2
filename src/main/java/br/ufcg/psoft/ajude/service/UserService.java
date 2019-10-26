package br.ufcg.psoft.ajude.service;

import br.ufcg.psoft.ajude.models.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);
    List<User> findAll();
    User createUser(User user);
    void deleteByEmail(String email);
    void deleteAll();

}
