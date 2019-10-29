package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.repositories.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/campaign/{id}/comment")
public class CommentController {

    @Autowired
    private CommentDAO commentDAO;


}
