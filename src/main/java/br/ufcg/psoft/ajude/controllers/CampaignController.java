package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.business.CampaignBusinessDelegate;
import br.ufcg.psoft.ajude.dto.CampaignDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Controller da campanha")
@RestController
@RequestMapping("/v1/campaign")
public class CampaignController {

    @Autowired
    private CampaignBusinessDelegate campaignBusinessDelegate;

    @CrossOrigin
    @ApiOperation(value = "Cadastra uma campanha")
    @PostMapping
    public ResponseEntity<CampaignDTO> addCampaign(@RequestBody CampaignDTO campaignDTO){
        return new ResponseEntity<>(this.campaignBusinessDelegate.createCampaign(campaignDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignDTO> getCampaign(@PathVariable Long id){
        return new ResponseEntity<>(campaignBusinessDelegate.findById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @ApiOperation(value = "Busca uma campanha pela sua URL")
    @GetMapping("/buscar/{url}")
    public ResponseEntity<CampaignDTO> getByUrl(@PathVariable String url){
        return new ResponseEntity<>(campaignBusinessDelegate.findByUrl(url), HttpStatus.OK);
    }

    @CrossOrigin
    @ApiOperation(value = "Busca todas as campanhas cadastradas a partir de uma ordem ou não")
    @GetMapping
    public ResponseEntity<List<CampaignDTO>> getAll(@RequestParam (required = false) String order) {
        List<CampaignDTO> campaigns = campaignBusinessDelegate.orderBy(order);
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }

    @CrossOrigin
    @ApiOperation(value = "Busca uma campanha a partir de uma substring")
    @GetMapping("/search/{campaign}")
    public ResponseEntity<List<CampaignDTO>> getBySubstring(@PathVariable String campaign) {
        return new ResponseEntity<>(this.campaignBusinessDelegate.findBySubstring(campaign), HttpStatus.OK);
    }

    @CrossOrigin
    @ApiOperation(value = "Um usuário autenticado pode dar like em campanhas")
    @PostMapping("/{idCampaign}/like")
    public ResponseEntity<CampaignDTO> toLike(@PathVariable long idCampaign){
        return new ResponseEntity<>(this.campaignBusinessDelegate.toLike(idCampaign), HttpStatus.OK);
    }

}
