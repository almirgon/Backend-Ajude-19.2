package br.ufcg.psoft.ajude.service;

import br.ufcg.psoft.ajude.exceptions.email.EmailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("AJuDE");
        message.setText("Seja bem vindo ao AJuDE, " +
                "plataforma para financiamento coletivo onde as causas mais populares ganham mais visibilidade");
        message.setTo(email);
        message.setFrom("ajudepsoft192@gmail.com");

        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmailNotFoundException("Email não existe!");
        }
    }
}
