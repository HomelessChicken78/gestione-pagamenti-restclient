package it.itsacademy.gestionepagamentirestclient.service;

import it.itsacademy.gestionepagamentirestclient.dto.*;

import java.util.Collection;
import java.util.UUID;

public interface PagamentoService {
    Collection<PagamentoDTO> listaPagamenti(UUID idOrdine);
}
