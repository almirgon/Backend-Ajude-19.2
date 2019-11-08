package br.ufcg.psoft.ajude.service.campaign;

import br.ufcg.psoft.ajude.exceptions.entity.EntityNotFoundException;
import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.Status;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.repositories.CampaignDAO;
import br.ufcg.psoft.ajude.validators.CampaignValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignBean implements CampaignService {

    @Autowired
    private CampaignDAO campaignDAO;

    @Autowired
    private CampaignValidator campaignValidator;

    @Override
    public Campaign findById(Long id) {
        Campaign result = this.campaignDAO.findCampaignById(id);
        if (result == null) {
            throw new EntityNotFoundException("Campanha não encontrada!");
        }
        return result;
    }

    @Override
    public List<Campaign> findAll() {
        List<Campaign> campaigns = campaignDAO.findAll();
        return campaigns;
    }

    @Override
    public Campaign findByUrl(String url) {
        return null;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {
        campaignValidator.ValidCampaign(campaign);
        campaign.setStatus(Status.ATIVA);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        campaign.setUser(user);
        campaign.setUrl(campaign.getUrl());
        return campaignDAO.save(campaign);
    }

   // @Override
    //public List<Campaign> listByLike() {
        //return this.campaignDAO.findAllCampaignByOrderByLikesDesc();
    //}

    @Override
        public List<Campaign> findBySubstring(String campaign) {
            return this.campaignDAO.findBySubstring(campaign.toLowerCase());
    }

    @Override
    public Campaign toLike(User user, long id) {
        user = (User) SecurityContextHolder.getContext().getAuthentication();
        Campaign campaign = this.findById(id);
        campaign.addLikes(user);
        return campaign;
    }
}
