package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.models.Comment;
import br.ufcg.psoft.ajude.service.comment.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Controller de comentarios")
@RestController
@RequestMapping("/v1/campaign/{idCampaign}/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping()
    @ApiOperation(value = "Cria um comentário para uma campanha")
    public ResponseEntity<Comment> toComment(@PathVariable long idCampaign, @RequestBody Comment comment){
        return new ResponseEntity<>(this.commentService.createComment(idCampaign,comment), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    @ApiOperation(value = "Responde um comentário de uma campanha")
    public ResponseEntity<Comment> replyComment(@PathVariable long id, @RequestBody Comment comment){
        return new ResponseEntity<>(this.commentService.ReplyComment(id,comment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta o comentário de uma campanhas")
    public ResponseEntity<Comment> deleteComment(@PathVariable long id){
        return new ResponseEntity<>(this.commentService.deleteComment(id), HttpStatus.OK);
    }


}
