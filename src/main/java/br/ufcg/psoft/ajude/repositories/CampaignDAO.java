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

    @Query(value = "SELECT p FROM Campaign p")
    List<Campaign> getAllCampaigns();

    @Query(value = "SELECT p FROM Campaign p ORDER BY p.date")
    List<Campaign> getCampaignsByDate();

    @Query(value = "SELECT p FROM Campaign p ORDER BY p.goal")
    List<Campaign> getCampaignsByGoal();

    @Query(value = "SELECT p FROM Campaign p ORDER BY p.numLikes DESC, p.id ASC")
    List<Campaign> getCampaignsByLike();

    @Query(value="SELECT p FROM Campaign p WHERE LOWER(p.name) LIKE %:campaign%")
    List<Campaign> findBySubstring(String campaign);

    @Query(value = "SELECT d.campaign FROM Donation d WHERE d.user.email = :email")
    List<Campaign> getCampaignsbyDonateUser(String email);

    @Query(value = "SELECT p FROM Campaign p WHERE p.user.email = :email")
    List<Campaign> getCampaignsCreateByUser(String email);

}
