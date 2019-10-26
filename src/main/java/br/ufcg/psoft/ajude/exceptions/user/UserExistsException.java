package br.ufcg.psoft.ajude.exceptions.user;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String s) {
        super(s);
    }
}
