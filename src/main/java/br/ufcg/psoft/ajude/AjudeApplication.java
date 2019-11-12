package br.ufcg.psoft.ajude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class AjudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjudeApplication.class, args);
	}

}
