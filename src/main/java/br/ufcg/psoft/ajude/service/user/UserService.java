package br.ufcg.psoft.ajude.service.user;

import br.ufcg.psoft.ajude.models.User;

public interface UserService {

    User findByEmail(String email);
    User createUser(User user);



}
