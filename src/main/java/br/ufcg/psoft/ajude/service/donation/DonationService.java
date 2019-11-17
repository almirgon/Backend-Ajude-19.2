package br.ufcg.psoft.ajude.service.donation;

import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.Donation;

public interface DonationService {

    Campaign donate(Long idCampaign, Donation donation);
}
