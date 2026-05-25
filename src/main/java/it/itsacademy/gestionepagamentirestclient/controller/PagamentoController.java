package it.itsacademy.gestionepagamentirestclient.controller;

import it.itsacademy.gestionepagamentirestclient.dto.PagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamenti")
@RequiredArgsConstructor
public class PagamentoController {
    private static final String JSON = "application/json";
    private final PagamentoService pagamentoService;

    @PostMapping(consumes = JSON, produces = JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoDTO paga() {
        return pagamentoService.paga();
    }
}