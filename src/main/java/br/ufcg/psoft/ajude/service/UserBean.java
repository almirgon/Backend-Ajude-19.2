package br.ufcg.psoft.ajude.service;

import br.ufcg.psoft.ajude.exceptions.user.UserExistsException;
import br.ufcg.psoft.ajude.exceptions.user.UserInvalidException;
import br.ufcg.psoft.ajude.exceptions.user.UserNotFoundException;
import br.ufcg.psoft.ajude.exceptions.user.UserNullException;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBean implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findByEmail(String email) {
        User result = this.userDAO.findByEmail(email);
        if (result == null) {
            throw new UserNotFoundException("Usuário não encontrado!");
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDAO.findAll();
        if (users.isEmpty()) {
            throw new UserNotFoundException("Não existem usuários");
        }
        return users;
    }

    @Override
    public User createUser(User user) {
        if (user.getFirstName() == null) throw new UserNullException("O primeiro nome não pode ser nulo, insira um nome valido");
        if (user.getFirstName().trim().equals("")) throw new UserInvalidException("O primeiro nome não pode ser vazio, insira um nome valido");

        User findUser = this.userDAO.findByEmail(user.getEmail());

        if (!(findUser == null)) {
            throw new UserExistsException("Email já Cadastrado");
        }

        return userDAO.save(user);

    }

    @Override
    public void deleteByEmail(String email) {
        User findUser = this.userDAO.findByEmail(email);

        if(findUser == null) throw new UserNotFoundException("O usuario não existe");

        userDAO.deleteById(email);


    }

    @Override
    public void deleteAll() {
        this.userDAO.deleteAll();
    }
}
