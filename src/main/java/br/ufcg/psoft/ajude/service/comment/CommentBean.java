package br.ufcg.psoft.ajude.service.comment;

import br.ufcg.psoft.ajude.exceptions.comment.CommentInvalidException;
import br.ufcg.psoft.ajude.exceptions.comment.CommentNullException;
import br.ufcg.psoft.ajude.exceptions.entity.EntityNotFoundException;
import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.Comment;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.repositories.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentBean implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Comment findById(Long id) {
        Comment comment = this.commentDAO.findById(id).get();
        if(comment == null){
            throw new CommentNullException("Comentário não existe");
        }if(comment.isCommentDeleted()){
            throw new CommentInvalidException("Comentário Apagado!");
        }
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = this.commentDAO.findAll();
        if(comments.isEmpty()){
            throw new EntityNotFoundException("Não há campanhas cadastradas");
        }
        return comments;
    }

    @Override
    public Comment createComment(Campaign campaign, User user, String text, long idComment) {
        if(text == null) throw new CommentNullException("O comentario não pode ser nulo");
        if(text.trim().equals("")) throw new CommentInvalidException("O comentário não pode ser vazio");
        if(user == null)throw new CommentNullException("O usuario não pode ser nulo");
        if(campaign == null)throw new CommentNullException("A campanha não pode ser nula");

        String hour = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern("HH:mm"));
        String date = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Comment comment = new Comment(campaign,user,text,date,hour, new ArrayList<Comment>());

        if (idComment == 0) {
            campaign.addComment(comment);
        } else {
            Comment commentFather = findById(idComment);
            commentFather.addAnswer(comment);
        }

        return commentDAO.save(comment);

    }

    @Override
    public Comment ReplyComment(long idComment, Comment comment) {
        return null;
    }

    @Override
    public Comment deleteComment(long idComment) {
        Comment comment = commentDAO.findById(idComment).get();
        Campaign campaign = comment.getCampaign();
        comment.setCommentDeleted(true);

        deleteChildrens(comment.getAnswers());
        commentDAO.save(comment);
        return comment;
    }

    private void deleteChildrens(List<Comment> list) {

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCommentDeleted(true);
                deleteChildrens(list.get(i).getAnswers());
            }

        }
    }

}
