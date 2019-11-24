package br.ufcg.psoft.ajude.service.comment;

import br.ufcg.psoft.ajude.exceptions.OperationNotAllowedException;
import br.ufcg.psoft.ajude.exceptions.comment.CommentInvalidException;
import br.ufcg.psoft.ajude.exceptions.comment.CommentNullException;
import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.Comment;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.repositories.CommentDAO;
import br.ufcg.psoft.ajude.service.campaign.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommentBean implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private CampaignService campaignService;

    @Override
    public Comment findById(Long id) {
        Optional<Comment> comment = this.commentDAO.findById(id);
        if(!comment.isPresent()){
            throw new CommentNullException("Comentário não existe");
        }

        if(comment.get().isCommentDeleted()){
            throw new CommentInvalidException("Comentário Apagado!");
        }

        return comment.get();
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = this.commentDAO.findAll();
        return comments;
    }

    @Override
    public Comment createComment(long idCampaign, Comment comment) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Campaign campaign = this.campaignService.findById(idCampaign);
        comment.setUser(user);
        comment.setDate(LocalDate.now());
        comment.setCommentDeleted(false);
        commentDAO.save(comment);
        campaign.addComment(comment);
        campaignService.updateCampaign(campaign);
        return comment;

    }

    @Override
    public Comment ReplyComment(long idComment, Comment comment) {
        Comment parent = commentDAO.findById(idComment);
        comment.setDate(LocalDate.now());
        comment.setCommentDeleted(false);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setUser(user);
        commentDAO.save(comment);
        parent.addAnswer(comment);
        commentDAO.save(parent);


        return comment;
    }


    @Override
    public Comment deleteComment(long idComment) {
        Comment comment = commentDAO.findById(idComment);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(comment.getUser().equals(user))){
            throw new OperationNotAllowedException("O comentário não pertence ao usuario logado");
        }
        comment.setCommentDeleted(true);
        deleteChildrens(comment.getAnswers());
        commentDAO.save(comment);
        return comment;
    }

    private void deleteChildrens(List<Comment> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCommentDeleted(true);
                deleteChildrens(list.get(i).getAnswers());
            }
        }
    }
}
