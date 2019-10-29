package br.ufcg.psoft.ajude.service.campaign;

import br.ufcg.psoft.ajude.exceptions.entity.EntityExistsException;
import br.ufcg.psoft.ajude.exceptions.entity.EntityNotFoundException;
import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.models.dtos.SubjectDTO;
import br.ufcg.psoft.ajude.repositories.CampaignDAO;
import br.ufcg.psoft.ajude.validators.CampaignValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignBean implements CampaignService {

    @Autowired
    private CampaignDAO campaignDAO;

    @Override
    public Campaign findById(Long id) {
        Campaign result = this.campaignDAO.findCampaignById(id);
        CampaignValidator.ValidCampaign(result);
        if (result == null) {
            throw new EntityNotFoundException("Campanha não encontrada!");
        }
        return result;
    }

    @Override
    public List<Campaign> findAll() {
        List<Campaign> campaigns = campaignDAO.findAll();
        if (campaigns.isEmpty()) {
            throw new EntityNotFoundException("Não existem campanhas");
        }
        return campaigns;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {
        CampaignValidator.ValidCampaign(campaign);

        Campaign findCampaign = this.campaignDAO.findCampaignById(campaign.getId());

        if (!(findCampaign == null)) {
            throw new EntityExistsException("Campanha já existe");
        }

        return campaignDAO.save(campaign);
    }

    @Override
    public void deleteById(long id) {
        Campaign findCampaign = this.campaignDAO.findCampaignById(id);

        if(findCampaign == null) throw new EntityNotFoundException("Campanha não existe");

        campaignDAO.deleteById(id);

    }

    @Override
    public void deleteAll() {
        this.campaignDAO.deleteAll();
    }

    @Override
    public List<Campaign> listByLike() {
        return this.campaignDAO.findAllCampaignByOrderByLikesDesc();
    }

    @Override
    public List<SubjectDTO> findBySubstring(String substring) {
        if (substring.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<SubjectDTO> list = new ArrayList<>();
            for (Campaign campaign : campaignDAO.findBySubstring(substring)) {
                list.add(new SubjectDTO(campaign.getId(), campaign.getName()));

            }
            return list;

        }
    }

    @Override
    public Campaign toLike(User user, long id) {
        return null;
    }
}
