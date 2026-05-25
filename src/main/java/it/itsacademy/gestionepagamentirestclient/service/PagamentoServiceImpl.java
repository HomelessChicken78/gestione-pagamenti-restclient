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

import java.util.UUID;

@Service @Transactional(noRollbackFor = PaymentRequiredException.class) // Con questo il motore di persistenza non fà il rollback quando questa eccezione è lanciata
@RequiredArgsConstructor
public class PagamentoServiceImpl implements PagamentoService {
    private final PagamentoMapper mapper;
    private final RepositoryPagamento repositoryPagamento;

    @Override
    public PagamentoDTO paga(UUID idOrdine, CreaPagamentoDTO pagamentoDaCreare) {
        Pagamento nuovoPagamento = new Pagamento();
        nuovoPagamento.setIdOrdine(idOrdine);
        nuovoPagamento.setTotale(pagamentoDaCreare.getTotale());

        Pagamento salvato = repositoryPagamento.save(nuovoPagamento);

        // Decidi randomicamente se viene accettato o rifiutato
        if (Math.random() < 0.5)
            salvato.setStatoPagamento(Pagamento.StatoPagamento.ACCETTATO);
        else {
            salvato.setStatoPagamento(Pagamento.StatoPagamento.RIFIUTATO);

            // Notare: grazie a noRollbackFor, non viene effettuato rollback e quindi il pagamento viene comunque salvato
            throw new PaymentRequiredException("Pagamento fallito.");
        }

        return mapper.toDTO(salvato);
    }
}
