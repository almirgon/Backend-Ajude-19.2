package br.ufcg.psoft.ajude.service.campaign;

import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.models.dtos.SubjectDTO;

import java.util.List;

public interface CampaignService {

    Campaign findById(Long id);
    List<Campaign> findAll();
    Campaign createCampaign(Campaign campaign);
    void deleteById(long id);
    void deleteAll();
    List<Campaign> listByLike();
    List<SubjectDTO> findBySubstring(String substring);
    Campaign toLike(User user, long id);
}
