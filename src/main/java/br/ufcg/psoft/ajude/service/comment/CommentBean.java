package br.ufcg.psoft.ajude.service.comment;

import br.ufcg.psoft.ajude.exceptions.comment.CommentInvalidException;
import br.ufcg.psoft.ajude.exceptions.comment.CommentNullException;
import br.ufcg.psoft.ajude.exceptions.entity.EntityNotFoundException;
import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.Comment;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.repositories.CommentDAO;
import br.ufcg.psoft.ajude.validators.CommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentBean implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Optional<Comment> findById(Long id) {
        Optional<Comment> comment = this.commentDAO.findById(id);
        if(comment.isPresent()){
            throw new CommentNullException("Comentário não existe");
        }if(comment.get().isCommentDeleted()){
            throw new CommentInvalidException("Comentário Apagado!");
        }
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = this.commentDAO.findAll();
        return comments;
    }

    @Override
    public Comment createComment(Campaign campaign, User user, String text, long idComment) {
//        ZonedDateTime date = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
//
//        Comment comment = new Comment(idComment,user,text,date,new ArrayList<Comment>());
//
//        CommentValidator.ValidComment(comment);
//
//        if (idComment == 0) {
//            campaign.addComment(comment);
//        } else {
//            Comment commentFather = findById(idComment).get();
//            commentFather.addAnswer(comment);
//        }
//
//        return commentDAO.save(comment);

        return null;

    }

    @Override
    public Comment ReplyComment(long idComment, Comment comment) {
       return null;

    }

    @Override
    public Comment deleteComment(long idComment) {
        Comment comment = commentDAO.findById(idComment);
        comment.setCommentDeleted(true);

//        deleteChildrens(comment.getAnswers());
        commentDAO.save(comment);
        return comment;
    }

    private void deleteChildrens(List<Comment> list) {

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCommentDeleted(true);
//                deleteChildrens(list.get(i).getAnswers());
            }

        }
    }

}
