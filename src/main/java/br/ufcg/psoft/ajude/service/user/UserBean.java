package br.ufcg.psoft.ajude.service.user;

import br.ufcg.psoft.ajude.exceptions.entity.EntityExistsException;
import br.ufcg.psoft.ajude.exceptions.entity.EntityNotFoundException;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.repositories.UserDAO;
import br.ufcg.psoft.ajude.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBean implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findByEmail(String email) {
        User result = this.userDAO.findUserByEmail(email);
        if (result == null) {
            throw new EntityNotFoundException("Usuário não encontrado!");
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDAO.findAll();
        if (users.isEmpty()) {
            throw new EntityNotFoundException("Não existem usuários");
        }
        return users;
    }

    @Override
    public User createUser(User user) {
        UserValidator.ValidUser(user);
        User findUser = this.userDAO.findUserByEmail(user.getEmail());

        if (!(findUser == null)) {
            throw new EntityExistsException("Email já Cadastrado");
        }
        return userDAO.save(user);

    }

    @Override
    public void deleteByEmail(String email) {
        User findUser = this.userDAO.findUserByEmail(email);
        UserValidator.ValidUser(findUser);

        if(findUser == null) throw new EntityNotFoundException("O usuario não existe");
        userDAO.deleteById(email);


    }

    @Override
    public void deleteAll() {
        this.userDAO.deleteAll();
    }
}
