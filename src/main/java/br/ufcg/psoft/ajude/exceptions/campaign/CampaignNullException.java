package br.ufcg.psoft.ajude.exceptions.campaign;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampaignNullException extends RuntimeException {
    public CampaignNullException(String msg){
        super(msg);
    }
}
