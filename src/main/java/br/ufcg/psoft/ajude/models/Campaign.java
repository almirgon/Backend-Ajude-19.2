package br.ufcg.psoft.ajude.models;

import br.ufcg.psoft.ajude.dto.CommentDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.Normalizer;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_campaign")
public class Campaign implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String name;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime date;

    @Column
    private Status status;

    @NotNull
    @Column
    private Double goal;

    @OneToMany
    private List<Donation> totalDonation;

    @Column
    private String url;

    @OneToMany
    private List<User> likes;

    @OneToMany(cascade = CascadeType.ALL)
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
        this.donations = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }

    public List<Donation> getTotalDonation() {
        return totalDonation;
    }

    public Double getRaisedAmount(){
        return getDonations().stream().collect(Collectors.summingDouble(value -> value.getValue()));
    }

    public void setTotalDonation(List<Donation> totalDonation) {
        this.totalDonation = totalDonation;
    }

    public int numberLikes() {
        if (this.likes != null)
            return this.likes.size();
        return 0;
    }

    public String createUrl(){
        String result = "";
        result = Normalizer.normalize(this.getName(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        result = result.replaceAll("\\s+", "-").toLowerCase();
        result = result.replaceAll("[.,;?!:#@]+","");
        return result;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {

        return comments.stream().filter(comment -> !comment.isCommentDeleted()).collect(Collectors.toList());
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

    public void removeComment(Comment comment){
        this.comments.remove(comment);
    }

    public String getUrl() {
        return this.url;
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

    public void addDonation(Donation donation){
        this.donations.add(donation);
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
