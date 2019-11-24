package br.ufcg.psoft.ajude.business;

import br.ufcg.psoft.ajude.dto.CampaignDTO;
import br.ufcg.psoft.ajude.dto.UserDTO;
import br.ufcg.psoft.ajude.dto.UserProfileDTO;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.service.campaign.CampaignService;
import br.ufcg.psoft.ajude.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProfileBusinessDelegate{

    @Autowired
    private UserService userService;

    @Autowired
    private CampaignService campaignService;

    public UserProfileDTO getProfile(String email) {
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        User user = this.userService.findByEmail(email);
        List<CampaignDTO> campaignsbyDonateUser = campaignService.getCampaignsbyDonateUser(email)
                .stream().map(campaign -> new CampaignDTO(campaign)).collect(Collectors.toList());
        List<CampaignDTO> campaignsCreateByUser = campaignService.getCampaignsCreateByUser(email).stream().
                map(campaign -> new CampaignDTO(campaign)).collect(Collectors.toList());
        userProfileDTO.setUser(new UserDTO(user));
        userProfileDTO.setCampaigns(campaignsCreateByUser);
        userProfileDTO.setDonations(campaignsbyDonateUser);

        return userProfileDTO;
    }
}
