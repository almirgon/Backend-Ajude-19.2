package br.ufcg.psoft.ajude.service.email;

import br.ufcg.psoft.ajude.exceptions.email.EmailNotFoundException;
import br.ufcg.psoft.ajude.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendMail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Seja bem vindo ao AJuDE");
        message.setText("Olá, " + user.getFirstName() + System.lineSeparator() +
               System.lineSeparator() + "Obrigado por se cadastrar na nossa plataforma para financiamento coletivo " +
                "onde as causas mais populares ganham mais visibilidade :)" + System.lineSeparator() +
                "Acesse nossa plataforma em: https://ajudepsoft192.herokuapp.com/#/login");
        message.setTo(user.getEmail());
        message.setFrom("AJuDE <ajudepsoft192@gmail.com>");

        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmailNotFoundException("Email não existe!");
        }
    }
}
