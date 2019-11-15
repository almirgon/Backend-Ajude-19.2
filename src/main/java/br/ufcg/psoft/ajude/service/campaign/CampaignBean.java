package br.ufcg.psoft.ajude.service.campaign;

import br.ufcg.psoft.ajude.exceptions.OperationNotAllowedException;
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
    public Campaign findById(long id) {
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
        Campaign result = this.campaignDAO.findByUrl(url);
        if (result == null) {
            throw new EntityNotFoundException("Campanha não encontrada!");
        }
        return result;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {
        campaignValidator.ValidCampaign(campaign);
        campaign.setStatus(Status.ATIVA);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        campaign.setUser(user);
        campaign.setUrl(campaign.createUrl());
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
        User userContext = (User) SecurityContextHolder.getContext().getAuthentication();
        Campaign campaign = this.findById(id);
        if(user.equals(userContext) && campaign != null){
            if(!campaign.getLikes().contains(user)){
                campaign.getLikes().add(user);
            }else{
                campaign.getLikes().remove(user);
            }
            return this.campaignDAO.save(campaign);
        }
        return null;
    }

    @Override
    public Campaign updateCampaign(Campaign campaign) {
        if(campaign.getId() == null){
            throw new OperationNotAllowedException("Não é permitido criar uma entidade");
        }
        return campaignDAO.save(campaign);
    }
}
