package br.ufcg.psoft.ajude.service.donation;

import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.Donation;
import br.ufcg.psoft.ajude.models.Status;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.repositories.DonationDAO;
import br.ufcg.psoft.ajude.service.campaign.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DonationBean implements DonationService {

    @Autowired
    private DonationDAO donationDAO;

    @Autowired
    private CampaignService campaignService;

    @Override
    public Campaign donate(Long idCampaign, Donation donation) {
        Campaign campaign = this.campaignService.findById(idCampaign);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        donation.setCampaign(campaign);
        donation.setUser(user);
        donation.setDate(LocalDate.now());
        if(campaign.getStatus() == Status.ATIVA){
            donationDAO.save(donation);
            campaign.addDonation(donation);
            if(campaign.getRaisedAmount() >= campaign.getGoal()){
                campaign.setStatus(Status.CONCLUIDA);
            }

        }
         return campaignService.updateCampaign(campaign);

    }
}
