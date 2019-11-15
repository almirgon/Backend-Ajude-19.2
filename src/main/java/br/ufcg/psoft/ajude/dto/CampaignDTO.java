package br.ufcg.psoft.ajude.dto;

import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.Comment;
import br.ufcg.psoft.ajude.models.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.ZonedDateTime;
import java.util.List;

public class CampaignDTO {

    private Campaign campaign;

    public CampaignDTO() {
        this.campaign = new Campaign();
    }

    public CampaignDTO(Campaign campaign) {
        this.campaign = campaign;
    }

    @JsonIgnore
    public Campaign getCampaign(){
        return campaign;
    }

    public String getUrl(){
        return campaign.getUrl();
    }

    public void setUrl(String url){
        campaign.setUrl(url);
    }

    public long getId(){
        return campaign.getId();
    }

    public void setId(long id){
        campaign.setId(id);
    }

    public String getName(){
        return campaign.getName();
    }

    public void setName(String name){
        campaign.setName(name);
    }

    public ZonedDateTime getDate(){
        return campaign.getDate();
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    public void setDate(ZonedDateTime date){
        campaign.setDate(date);
    }

    public Double getGoal(){
        return campaign.getGoal();
    }

    public void setGoal(Double goal){
        campaign.setGoal(goal);
    }

    public List<Comment> getComments(){
        return campaign.getComments();
    }

    public void setComments(List<Comment> comments){
        campaign.setComments(comments);
    }

    public UserDTO getUser(){
        return new UserDTO(campaign.getUser());
    }

    public void setUser(User user){
        campaign.setUser(user);
    }

    public Double getRaisedAmount(){
       return campaign.getRaisedAmount();
    }

    public String getDescription(){
        return campaign.getDescription();
    }

    public void setDescription(String description){
        campaign.setDescription(description);
    }
}
