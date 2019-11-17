package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.business.CommentBusinessDelegate;
import br.ufcg.psoft.ajude.dto.CommentDTO;
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
    private CommentBusinessDelegate commentBusinessDelegate;

    @PostMapping()
    @ApiOperation(value = "Cria um comentário para uma campanha")
    public ResponseEntity<CommentDTO> toComment(@PathVariable long idCampaign, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(this.commentBusinessDelegate.createComment(idCampaign,commentDTO), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    @ApiOperation(value = "Responde um comentário de uma campanha")
    public ResponseEntity<CommentDTO> replyComment(@PathVariable long id, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(this.commentBusinessDelegate.replyComment(id,commentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta o comentário de uma campanhas")
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable long id){
        return new ResponseEntity<>(this.commentBusinessDelegate.removeComment(id), HttpStatus.OK);
    }


}
