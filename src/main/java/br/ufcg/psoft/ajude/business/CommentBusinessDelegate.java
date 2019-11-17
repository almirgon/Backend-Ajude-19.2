package br.ufcg.psoft.ajude.business;

import br.ufcg.psoft.ajude.dto.CommentDTO;
import br.ufcg.psoft.ajude.models.Comment;
import br.ufcg.psoft.ajude.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentBusinessDelegate {

    @Autowired
    private CommentService commentService;

    public CommentDTO findCommentById(long id){
        return new CommentDTO(this.commentService.findById(id));
    }

    public List<CommentDTO> findAllComments(){
        return this.commentService.findAll().stream().map(comment -> new CommentDTO(comment)).collect(Collectors.toList());
    }

    public CommentDTO createComment(long idCampaign, CommentDTO commentDTO){
        return new CommentDTO(this.commentService.createComment(idCampaign,commentDTO.getComment()));
    }

    public CommentDTO replyComment(long idComment, CommentDTO commentDTO){
        return new CommentDTO((this.commentService.ReplyComment(idComment,commentDTO.getComment())));
    }

    public CommentDTO removeComment(long idComment){
        return new CommentDTO(this.commentService.deleteComment(idComment));
    }
}
