package br.ufcg.psoft.ajude.service.comment;

import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.Comment;
import br.ufcg.psoft.ajude.models.User;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Comment findById(Long id);
    List<Comment> findAll();
    Comment createComment(long idCampaign, Comment comment);
    Comment ReplyComment(long idComment, Comment comment);
    Comment deleteComment(long idComment);

}
