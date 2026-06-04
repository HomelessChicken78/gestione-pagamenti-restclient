package it.itsacademy.gestionepagamentirestclient.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamenti")
public class HealthCheckController {

    @GetMapping(path = "/health")
    public void health() {}
}