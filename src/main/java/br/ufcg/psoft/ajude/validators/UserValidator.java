package br.ufcg.psoft.ajude.validators;

import br.ufcg.psoft.ajude.exceptions.password.PasswordInvalidException;
import br.ufcg.psoft.ajude.exceptions.user.UserInvalidException;
import br.ufcg.psoft.ajude.exceptions.user.UserNullException;
import br.ufcg.psoft.ajude.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public void ValidUser(User user){
        //validar primeiro o usuario
        if(user.getPassword() == null || user.getPassword().isEmpty()) throw new PasswordInvalidException("Senha inválida");
        if(user.getFirstName() == null) throw new UserNullException("O primeiro nome não pode ser nulo, insira um nome válido");
        if(user.getFirstName().trim().equals("")) throw new UserInvalidException("O primeiro nome não pode ser vazio, insira um nome válido");
        if(user.getCard() == null || user.getCard().trim().equals("")) throw new UserInvalidException("Cartão inválido");
        if(user.getLastName() == null) throw new UserNullException("O último nome não pode ser nulo, insira um nome válido");
        if(user.getLastName().trim().equals("")) throw new UserInvalidException("O último nome não pode ser vazio, insira um nome válido");
        if(user.getEmail() == null) throw new UserNullException("O email não pode ser nulo, insira um email válido");
        if(user.getEmail().trim().equals("")) throw new UserInvalidException("O email não pode ser vazio, insira um email válido");


    }
}
