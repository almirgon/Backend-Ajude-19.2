package br.ufcg.psoft.ajude.exceptions.comment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CommentNullException extends RuntimeException {
    public CommentNullException(String msg){
        super(msg);
    }
}
