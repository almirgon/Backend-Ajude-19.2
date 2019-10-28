package br.ufcg.psoft.ajude.exceptions.entity;

public class EntityExistsException extends RuntimeException {
    public EntityExistsException(String msg){
        super(msg);
    }
}
