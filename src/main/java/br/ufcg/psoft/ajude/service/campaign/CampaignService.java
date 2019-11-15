package br.ufcg.psoft.ajude.service.campaign;

import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.User;

import java.util.List;

public interface CampaignService {

    Campaign findById(long id);
    List<Campaign> findAll();
    Campaign findByUrl(String url);
    Campaign createCampaign(Campaign campaign);
   // List<Campaign> listByLike();
    List<Campaign> findBySubstring(String campaign);
    Campaign toLike(User user, long id);
    Campaign updateCampaign(Campaign campaign);
}
