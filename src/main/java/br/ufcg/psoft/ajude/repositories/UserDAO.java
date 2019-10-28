package br.ufcg.psoft.ajude.repositories;

import br.ufcg.psoft.ajude.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

    User findUserByEmail(String email);

}
