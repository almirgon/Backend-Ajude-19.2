package br.ufcg.psoft.ajude.repositories;

import br.ufcg.psoft.ajude.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignDAO extends JpaRepository<Campaign, Long> {

    Campaign findCampaignById(Long id);

    Campaign findByUrl(String url);

    @Query(value = "SELECT u FROM Campaign u")
    List<Campaign> getAllCampaigns();

    //@Query(value = "SELECT p FROM Campaign p ORDER BY p.Likes DESC,p.id ASC")
    //List<Campaign> findAllCampaignByOrderByLikesDesc();

    @Query(value="SELECT p FROM Campaign p WHERE LOWER(p.name) LIKE %:campaign%")
    List<Campaign> findBySubstring(String campaign);
}
