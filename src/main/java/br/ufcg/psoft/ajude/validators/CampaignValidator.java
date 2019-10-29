package br.ufcg.psoft.ajude.validators;

import br.ufcg.psoft.ajude.exceptions.campaign.CampaignInvalidException;
import br.ufcg.psoft.ajude.exceptions.campaign.CampaignNullException;
import br.ufcg.psoft.ajude.models.Campaign;

public class CampaignValidator {

    public static void ValidCampaign(Campaign campaign){
        if(campaign.getName() == null) throw new CampaignNullException("O nome da campanha não pode ser nulo");
        if(campaign.getName().trim().equals("")) throw new CampaignInvalidException("O nome da campanha não pode ser vazio");
        if(campaign.getDescription() == null) throw new CampaignNullException("A descrição não pode ser nula");
        if(campaign.getDescription().trim().equals("")) throw new CampaignInvalidException("A descrição não pode ser vazia");
        if(campaign.getStatus().getDescription() == null) throw new CampaignNullException("O status não pode ser nulo");
        if(campaign.getStatus().getDescription().trim().equals("")) throw new CampaignInvalidException("O status não pode ser vazio");
        if(campaign.getGoal() <= 0) throw new CampaignInvalidException("A meta não pode ser menor/igual a 0");
        if(campaign.getLikes() < 0) throw new CampaignInvalidException("Os likes não podem ser abaixo de 0");


    }
}
