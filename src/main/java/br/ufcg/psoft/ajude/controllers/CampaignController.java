package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.service.campaign.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;


    @PostMapping
    public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign){
        return new ResponseEntity<Campaign>(this.campaignService.createCampaign(campaign), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable Long id){
        try{
            return new ResponseEntity<Campaign>(campaignService.findById(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ranking/likes")
    public ResponseEntity<List<Campaign>> rankingByLike(){
        return new ResponseEntity<List<Campaign>>(campaignService.listByLike(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getAll() {
        List campaigns = campaignService.findAll();
        return new ResponseEntity<List<Campaign>>(campaigns, HttpStatus.OK);
    }


}
