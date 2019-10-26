package br.ufcg.psoft.ajude.exceptions.email;

public class EmailInvalidException extends RuntimeException {

    public EmailInvalidException(String msg) {
        super(msg);
    }

}
