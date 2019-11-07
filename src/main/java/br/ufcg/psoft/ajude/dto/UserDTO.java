package br.ufcg.psoft.ajude.dto;

import br.ufcg.psoft.ajude.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {

    private User user;

    public UserDTO() {
       this.user = new User();
    }

    public UserDTO(User user) {
        this.user = user;
    }

    @JsonIgnore
    public User getUser(){
        return user;
    }

    public String getEmail(){
        return user.getEmail();
    }

    public void setEmail(String email){
        user.setEmail(email);
    }

    public String getFirstName(){
        return user.getFirstName();
    }

    public void setFirstName(String firstName){
        user.setFirstName(firstName);
    }

    public String getLastName(){
        return user.getLastName();
    }

    public void setLastName(String lastName){
        user.setLastName(lastName);
    }
}
