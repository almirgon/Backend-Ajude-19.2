package br.ufcg.psoft.ajude.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue
    private long idComment;

    @NotNull
    @Column
    private User user;

    @Column
    @Length(min = 0, max = 250)
    private String text;

    @NotNull
    @Column
    private String date;

    @NotNull
    @Column
    private String hour;

    private boolean commentDeleted;

    @OneToMany
    private List<Comment> answers;

    @ManyToOne
    @JsonBackReference(value = "parent")
    private Comment parent;

    public Comment() {

    }

    public Comment(User user,  String text,  String date,  String hour, List<Comment> answers) {
        this.user = user;
        this.text = text;
        this.date = date;
        this.hour = hour;
        this.answers = answers;
    }



    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public boolean isCommentDeleted() {
        return commentDeleted;
    }

    public void setCommentDeleted(boolean commentDeleted) {
        this.commentDeleted = commentDeleted;
    }

    public List<Comment> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Comment> answers) {
        this.answers = answers;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public void addAnswer(Comment comment){
        this.answers.add(comment);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return idComment == comment.idComment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComment);
    }
}
