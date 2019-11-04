package br.ufcg.psoft.ajude.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "t_user")
public class User implements Serializable {

    @Id
    @Column
    private String email;

    @NotNull
    @NotEmpty
    @Column
    private String firstName;

    @NotNull
    @NotEmpty
    @Column
    private String lastName;

    @NotNull
    @NotEmpty
    @Column
    private String card;

    @NotNull
    @NotEmpty
    @Column
    private String password;

    public User() {

    }

    public User(String email, String firstName, String lastName, String card, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.card = card;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
