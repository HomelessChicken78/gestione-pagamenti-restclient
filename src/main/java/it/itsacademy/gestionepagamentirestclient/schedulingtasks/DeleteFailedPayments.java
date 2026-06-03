package it.itsacademy.gestionepagamentirestclient.schedulingtasks;

import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import it.itsacademy.gestionepagamentirestclient.repository.RepositoryPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class DeleteFailedPayments {
    private final RepositoryPagamento repositoryPagamento;

    @Scheduled(fixedRate = 120000L)
    public void deleteFailedPayments() {
        Collection<Pagamento> failedPayments = repositoryPagamento.findWhereStatoRifiutato();

        for (Pagamento p : failedPayments)
            repositoryPagamento.deleteById(p.getIdPagamento());
    }
}
