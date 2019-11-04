package br.ufcg.psoft.ajude.exceptions.date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DateInvalidException extends RuntimeException {
    public DateInvalidException(String msg) {
            super(msg);
        }

    }
