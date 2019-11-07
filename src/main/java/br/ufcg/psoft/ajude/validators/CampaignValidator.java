package br.ufcg.psoft.ajude.validators;

import br.ufcg.psoft.ajude.exceptions.campaign.CampaignInvalidException;
import br.ufcg.psoft.ajude.exceptions.campaign.CampaignNullException;
import br.ufcg.psoft.ajude.exceptions.date.DateInvalidException;
import br.ufcg.psoft.ajude.models.Campaign;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class CampaignValidator {

    public void ValidCampaign(Campaign campaign){
        if(campaign == null) throw new CampaignNullException("A campanha não pode ser nula");
        if(campaign.getName() == null) throw new CampaignNullException("O nome da campanha não pode ser nulo");
        if(campaign.getName().trim().equals("")) throw new CampaignInvalidException("O nome da campanha não pode ser vazio");
        if(campaign.getDescription() == null) throw new CampaignNullException("A descrição não pode ser nula");
        if(campaign.getDescription().trim().equals("")) throw new CampaignInvalidException("A descrição não pode ser vazia");
        if(campaign.getGoal() <= 0) throw new CampaignInvalidException("A meta não pode ser menor/igual a 0");
        if(campaign.getLikes() < 0) throw new CampaignInvalidException("Os likes não podem ser abaixo de 0");
        if(campaign.getDate().isBefore(ZonedDateTime.now()) || campaign.getDate().isEqual(ZonedDateTime.now())) throw new
                DateInvalidException("A data não pode ser menor ou igual a atual");
    }
}
