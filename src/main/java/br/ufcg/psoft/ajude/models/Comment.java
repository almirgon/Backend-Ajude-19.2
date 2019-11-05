package br.ufcg.psoft.ajude.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Entity
@Table(name = "tb_comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComment;

    @ManyToOne
    private User user;

    @Column
    @Length(min = 0, max = 250)
    private String text;

    @NotNull
    @Column
    private ZonedDateTime date;

    private boolean commentDeleted;

    @OneToMany
    private List<Comment> answers;

    @ManyToOne
    @JsonBackReference(value = "parent")
    private Comment parent;

    @ManyToOne
    private Campaign campaign;


    public Comment() {

    }

//    public Comment(long idComment,User user,String text, ZonedDateTime date, boolean commentDeleted, List<Comment> answers) {
//        this.idComment = idComment;
//        this.user = user;
//        this.text = text;
//        this.date = date;
//        this.commentDeleted = commentDeleted;
//        this.answers = answers;
//
//    }


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
        DateTimeFormatter formatador = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(new Locale("pt", "br"));

        return date.format(formatador);
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public boolean isCommentDeleted() {
        return commentDeleted;
    }

    public void setCommentDeleted(boolean commentDeleted) {
        this.commentDeleted = commentDeleted;
    }

//    public List<Comment> getAnswers() {
//        return answers;
//    }

//    public void setAnswers(List<Comment> answers) {
//        this.answers = answers;
//    }
//
//    public Comment getParent() {
//        return parent;
//    }
//
//    public void setParent(Comment parent) {
//        this.parent = parent;
//    }
//
//    public void addAnswer(Comment comment){
//        this.answers.add(comment);
//    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
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
