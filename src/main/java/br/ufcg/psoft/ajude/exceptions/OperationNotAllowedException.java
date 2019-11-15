package br.ufcg.psoft.ajude.exceptions;

public class OperationNotAllowedException extends RuntimeException {

    public OperationNotAllowedException (String s){
        super(s);
    }
}
