package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.service.campaign.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping
    public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign){
        return new ResponseEntity<Campaign>(this.campaignService.createCampaign(campaign), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable Long id){
        return new ResponseEntity<Campaign>(campaignService.findById(id), HttpStatus.OK);
    }

//    @GetMapping("/ranking/likes")
//    public ResponseEntity<List<Campaign>> rankingByLike(){
//        return new ResponseEntity<List<Campaign>>(campaignService.listByLike(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getAll() {
        List campaigns = campaignService.findAll();
        return new ResponseEntity<List<Campaign>>(campaigns, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Campaign>> getBySubstring(@PathVariable String campaign) {
        return new ResponseEntity<>(this.campaignService.findBySubstring(campaign.toUpperCase()), HttpStatus.OK);
    }




}
