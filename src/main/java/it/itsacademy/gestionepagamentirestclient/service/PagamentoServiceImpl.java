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
import java.util.UUID;

@Service @Transactional
@RequiredArgsConstructor
public class PagamentoServiceImpl implements PagamentoService {
    private final PagamentoMapper mapper;
    private final RepositoryPagamento repositoryPagamento;

    @Override
    public PagamentoDTO paga(CreaPagamentoDTO pagamentoDaCreare) {
        Pagamento nuovoPagamento = new Pagamento();
        nuovoPagamento.setIdOrdine(pagamentoDaCreare.getIdOrdine());
        nuovoPagamento.setTotale(pagamentoDaCreare.getTotale());

        // Decidi randomicamente se viene accettato o rifiutato
        if (Math.random() < 0.5)
            nuovoPagamento.setStatoPagamento(Pagamento.StatoPagamento.ACCETTATO);
        else {
            nuovoPagamento.setStatoPagamento(Pagamento.StatoPagamento.RIFIUTATO);

            // Notare: A differenza di http dove possiamo ritornare uno status code dopo una eccezione,
            // con AMQ, il listener dopo un'eccezione pensa che c'è stato un problema e prova a reinviare il messaggio
            // nella queue causando un ciclo infinito (l'eccezione rimane sempre)
        }

        Pagamento salvato = repositoryPagamento.save(nuovoPagamento);

        return mapper.toDTO(salvato);
    }

    @Override
    public Collection<PagamentoDTO> listaPagamenti(UUID idOrdine) {
        return mapper.toDTO(repositoryPagamento.findByIdOrdine(idOrdine));
    }
}
