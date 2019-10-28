package br.ufcg.psoft.ajude.validators;

import br.ufcg.psoft.ajude.exceptions.password.PasswordInvalidException;
import br.ufcg.psoft.ajude.exceptions.user.UserInvalidException;
import br.ufcg.psoft.ajude.exceptions.user.UserNullException;
import br.ufcg.psoft.ajude.models.User;

public class UserValidator {

    public static void ValidUser(User user){

        if (user.getPassword() == null || user.getPassword().isEmpty()) throw new PasswordInvalidException("Senha inválida");
        if (user.getFirstName() == null) throw new UserNullException("O primeiro nome não pode ser nulo, insira um nome valido");
        if (user.getFirstName().trim().equals("")) throw new UserInvalidException("O primeiro nome não pode ser vazio, insira um nome valido");
        if (user.getCard() == null || user.getCard().trim().equals("")) throw new UserInvalidException("Cartão inválido");
        if(user.getLastName() == null) throw new UserNullException("O Ultimo nome não pode ser nulo, insira um nome valido");
        if(user.getLastName().trim().equals("")) throw new UserInvalidException("O ultimo nome não pode ser vazio, insira um nome valido");

    }
}
