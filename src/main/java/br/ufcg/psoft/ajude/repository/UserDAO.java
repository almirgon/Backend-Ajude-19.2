package br.ufcg.psoft.ajude.repository;

import br.ufcg.psoft.ajude.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

    @Query(value="Select u from User u where u.email=:pemail")
    public User findByEmail(@Param("pemail") String email);

}
