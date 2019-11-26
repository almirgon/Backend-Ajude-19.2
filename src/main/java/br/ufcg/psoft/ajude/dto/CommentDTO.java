package br.ufcg.psoft.ajude.dto;

import br.ufcg.psoft.ajude.models.Comment;
import br.ufcg.psoft.ajude.models.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CommentDTO {

    private Comment comment;

    public CommentDTO() {
        this.comment = new Comment();
    }

    public CommentDTO(Comment comment) {
        this.comment = comment;
    }

    @JsonIgnore
    public Comment getComment(){
        return this.comment;
    }

    public long getId(){
        return this.comment.getIdComment();
    }

    public void setId(long id){
        this.comment.setIdComment(id);
    }

    public String getText() {
        return this.comment.getText();
    }

    public void setText(String text) {
        comment.setText(text);
    }

    public LocalDate getDate(){ return comment.getDate(); }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public void setDate(LocalDate date){ this.comment.setDate(date);}

    public List<CommentDTO> getAnswers(){ return comment.getAnswers().stream().map(answer -> new CommentDTO(answer)).collect(Collectors.toList());}

    public void setAnswers(List<Comment> answers){ comment.setAnswers(answers);}

    public UserDTO getUser(){
        return new UserDTO(comment.getUser());
    }

    public void setUser(User user){ comment.setUser(user);}

    public void addAnswer(Comment comment){
        comment.addAnswer(comment);
    }
}
