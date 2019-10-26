package br.ufcg.psoft.ajude.exceptions.email;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(String msg) {
        super(msg);
    }

}