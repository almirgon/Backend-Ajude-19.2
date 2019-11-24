package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.dto.CampaignDTO;
import br.ufcg.psoft.ajude.models.Donation;
import br.ufcg.psoft.ajude.service.donation.DonationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Controller de doação")
@RestController
@RequestMapping("/v1/campaign/{idCampaign}/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @CrossOrigin
    @ApiOperation(value = "Um usuario autenticado pode relizar uma doação para uma campanha")
    @PostMapping
    public ResponseEntity<CampaignDTO> donate(@PathVariable Long idCampaign, @RequestBody Donation donation){
        return new ResponseEntity<CampaignDTO>(new CampaignDTO(this.donationService.donate(idCampaign,donation)), HttpStatus.OK);
    }
}
