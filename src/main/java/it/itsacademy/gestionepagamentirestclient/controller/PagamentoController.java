package it.itsacademy.gestionepagamentirestclient.controller;

import it.itsacademy.gestionepagamentirestclient.dto.CreaPagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.dto.PagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/pagamenti/{idOrdine}")
@RequiredArgsConstructor
public class PagamentoController {
    private static final String json = "application/json";
    private final PagamentoService pagamentoService;

    @GetMapping(produces = json)
    public Collection<PagamentoDTO> listaPagamenti(@PathVariable UUID idOrdine) {
        return pagamentoService.listaPagamenti(idOrdine);
    }
}