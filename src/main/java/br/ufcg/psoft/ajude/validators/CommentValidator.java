package br.ufcg.psoft.ajude.validators;

import br.ufcg.psoft.ajude.exceptions.comment.CommentInvalidException;
import br.ufcg.psoft.ajude.exceptions.comment.CommentNullException;
import br.ufcg.psoft.ajude.models.Comment;

public class CommentValidator {

    public static void ValidComment(Comment comment){
        if(comment.getText() == null) throw new CommentNullException("O comentário não pode ser nulo");
        if(comment.getText().trim().equals("")) throw new CommentInvalidException("O comentário não pode ser vazio");
        if(comment.getUser() == null) throw new CommentNullException("O comentário precisa ter um usuário associado");


    }
}
