package br.ufcg.psoft.ajude.exceptions.password;

public class PasswordInvalidException extends RuntimeException {
    public PasswordInvalidException(String s){
        super(s);
    }
}
