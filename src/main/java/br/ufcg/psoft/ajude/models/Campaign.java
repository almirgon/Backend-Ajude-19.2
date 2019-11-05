package br.ufcg.psoft.ajude.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Entity
@Table(name = "tb_campaign")
public class Campaign implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Column
    private String name;

    @Column
    private ZonedDateTime date;

    @Column
    private Status status;

    @NotNull
    @Column
    private double goal;

    @NotNull
    @NotEmpty
    @Column
    private String url;

    @OneToMany
    private List<User> likes;

    @OneToMany
    private List<Comment> comments;

    @Column
    @NotEmpty
    @Length(min = 5)
    private String description;

    @OneToMany
    private List<Donation> donations;

    @ManyToOne
    private User user;

    public Campaign() {

    }

    public Campaign(String name, double goal,
                    String url,
                    String description, User user) {
        this.name = name;
        this.goal = goal;
        this.url = url;
        this.description = description;
        this.user = user;
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

    public String getFormatedDate() {
        DateTimeFormatter formatador = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(new Locale("pt", "br"));

        return date.format(formatador);
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

    public void addLikes(User user){
        this.likes.add(user);
    }

    public void removeLike(User user){
        this.likes.remove(user);
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

    public void removeComent(Comment comment){
        this.comments.remove(comment);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
