package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.business.CampaignBusinessDelegate;
import br.ufcg.psoft.ajude.dto.CampaignDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Autowired
    private CampaignBusinessDelegate campaignBusinessDelegate;

    @PostMapping
    public ResponseEntity<CampaignDTO> addCampaign(@RequestBody CampaignDTO campaignDTO){
        return new ResponseEntity<>(this.campaignBusinessDelegate.createCampaign(campaignDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignDTO> getCampaign(@PathVariable Long id){
        return new ResponseEntity<>(campaignBusinessDelegate.findById(id), HttpStatus.OK);
    }

//    @GetMapping("/ranking/likes")
//    public ResponseEntity<List<Campaign>> rankingByLike(){
//        return new ResponseEntity<List<Campaign>>(campaignService.listByLike(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<CampaignDTO>> getAll() {
        List<CampaignDTO> campaigns = campaignBusinessDelegate.findAll();
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }

    @GetMapping("/search/{campaign}")
    public ResponseEntity<List<CampaignDTO>> getBySubstring(@PathVariable String campaign) {
        return new ResponseEntity<>(this.campaignBusinessDelegate.findBySubstring(campaign), HttpStatus.OK);
    }




}
