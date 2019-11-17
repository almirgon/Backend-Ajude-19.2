package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.dto.CampaignDTO;
import br.ufcg.psoft.ajude.models.Donation;
import br.ufcg.psoft.ajude.service.donation.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/campaign/{idCampaign}/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<CampaignDTO> donate(@PathVariable Long idCampaign, @RequestBody Donation donation){
        return new ResponseEntity<CampaignDTO>(new CampaignDTO(this.donationService.donate(idCampaign,donation)), HttpStatus.OK);
    }
}
