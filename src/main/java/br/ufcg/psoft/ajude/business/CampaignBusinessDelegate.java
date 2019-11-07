package br.ufcg.psoft.ajude.business;

import br.ufcg.psoft.ajude.dto.CampaignDTO;
import br.ufcg.psoft.ajude.models.User;
import br.ufcg.psoft.ajude.service.campaign.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignBusinessDelegate {

    @Autowired
    private CampaignService campaignService;

   public CampaignDTO findById(Long id){
       return new CampaignDTO(this.campaignService.findById(id));
   }
   public List<CampaignDTO> findAll(){

       return this.campaignService.findAll().stream().map(campaign -> new CampaignDTO(campaign)).collect(Collectors.toList());
   }
   public CampaignDTO findByUrl(String url){
       return new CampaignDTO((this.campaignService.findByUrl(url)));
   }
   public CampaignDTO createCampaign(CampaignDTO campaignDTO){
       return new CampaignDTO(this.campaignService.createCampaign(campaignDTO.getCampaign()));
   }

   public List<CampaignDTO> findBySubstring(String campaign){
       return this.campaignService.findBySubstring(campaign).stream().map(campaigns -> new CampaignDTO(campaigns)).collect(Collectors.toList());
   }
   public CampaignDTO toLike(User user, long id){
        return new CampaignDTO(this.campaignService.toLike(user,id));
   }

}
