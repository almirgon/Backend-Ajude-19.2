package br.ufcg.psoft.ajude.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "campaign")
public class Campaign implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private ZonedDateTime date;

    @NotNull
    @Column
    private Status status;

    @NotNull
    @Column
    private double goal;

    @OneToMany
    private List<User> likes;

    @OneToMany
    private List<Comment> comments;

    @Column
    @Length(min = 5)
    private String description;

    public Campaign() {

    }

    public Campaign(long id, String name,ZonedDateTime date, Status status,double goal,
                    List<User> likes, List<Comment> comments, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = status;
        this.goal = goal;
        this.likes = likes;
        this.comments = comments;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public int getLikes() {
        if (this.likes != null)
            return this.likes.size();
        return 0;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return id == campaign.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
