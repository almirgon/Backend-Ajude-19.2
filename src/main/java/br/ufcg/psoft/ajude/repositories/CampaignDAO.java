package br.ufcg.psoft.ajude.repositories;

import br.ufcg.psoft.ajude.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignDAO extends JpaRepository<Campaign, Long> {

    Campaign findCampaignById(Long id);

    List<Campaign> findAllCampaign();

    List<Campaign> findAllCampaignByOrderByLikesDesc();
}
