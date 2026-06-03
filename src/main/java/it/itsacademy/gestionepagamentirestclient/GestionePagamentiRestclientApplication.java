package it.itsacademy.gestionepagamentirestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GestionePagamentiRestclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionePagamentiRestclientApplication.class, args);
    }

}
