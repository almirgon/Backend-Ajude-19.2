package br.ufcg.psoft.ajude.dto;


import java.util.List;

public class UserProfileDTO {

    private UserDTO user;

    private List<CampaignDTO> campaigns;

    private List<CampaignDTO> donations;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<CampaignDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignDTO> campaigns) {
        this.campaigns = campaigns;
    }

    public List<CampaignDTO> getDonations() {
        return donations;
    }

    public void setDonations(List<CampaignDTO> donations) {
        this.donations = donations;
    }
}
