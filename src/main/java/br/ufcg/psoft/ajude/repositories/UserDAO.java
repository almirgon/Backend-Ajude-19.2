package br.ufcg.psoft.ajude.repositories;

import br.ufcg.psoft.ajude.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

    @Query(value="SELECT u FROM User u WHERE u.email = :email")
    User findUserByEmail(String email);

}
