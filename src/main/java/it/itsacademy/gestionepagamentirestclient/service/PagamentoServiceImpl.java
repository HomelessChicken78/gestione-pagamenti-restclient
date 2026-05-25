package it.itsacademy.gestionepagamentirestclient.service;

import it.itsacademy.gestionepagamentirestclient.dto.PagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.mapper.PagamentoMapper;
import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import it.itsacademy.gestionepagamentirestclient.repository.RepositoryPagamento;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @Transactional
@RequiredArgsConstructor
public class PagamentoServiceImpl implements PagamentoService {
    private final PagamentoMapper mapper;
    private final RepositoryPagamento repositoryPagamento;

    @Override
    public PagamentoDTO paga() {
        Pagamento nuovoPagamento = new Pagamento();

        // Decidi randomicamente se viene accettato o rifiutato
        if (Math.random() < 0.5)
            nuovoPagamento.setStatoPagamento(Pagamento.StatoPagamento.ACCETTATO);
        else
            nuovoPagamento.setStatoPagamento(Pagamento.StatoPagamento.RIFIUTATO);

        Pagamento salvato = repositoryPagamento.save(nuovoPagamento);

        return mapper.toDTO(salvato);
    }
}
