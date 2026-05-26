package it.itsacademy.gestionepagamentirestclient.service;

import it.itsacademy.gestionepagamentirestclient.dto.*;

import java.util.Collection;
import java.util.UUID;

public interface PagamentoService {
    PagamentoDTO paga(UUID idOrdine, CreaPagamentoDTO nuovoPagamento);

    Collection<PagamentoDTO> listaPagamenti(UUID idOrdine);
}
