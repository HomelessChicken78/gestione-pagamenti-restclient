package it.itsacademy.gestionepagamentirestclient.service;

import it.itsacademy.gestionepagamentirestclient.dto.CreaPagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.dto.PagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.exception.PaymentRequiredException;
import it.itsacademy.gestionepagamentirestclient.mapper.PagamentoMapper;
import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import it.itsacademy.gestionepagamentirestclient.repository.RepositoryPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service @Transactional(noRollbackFor = PaymentRequiredException.class) // Con questo il motore di persistenza non fà il rollback quando questa eccezione è lanciata
@RequiredArgsConstructor
public class PagamentoServiceImpl implements PagamentoService {
    private final PagamentoMapper mapper;
    private final RepositoryPagamento repositoryPagamento;

    @Override
    public Collection<PagamentoDTO> listaPagamenti(UUID idOrdine) {
        return mapper.toDTO(repositoryPagamento.findByIdOrdine(idOrdine));
    }
}
