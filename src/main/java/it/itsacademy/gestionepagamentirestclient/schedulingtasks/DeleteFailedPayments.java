package it.itsacademy.gestionepagamentirestclient.schedulingtasks;

import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import it.itsacademy.gestionepagamentirestclient.repository.RepositoryPagamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor @Slf4j
public class DeleteFailedPayments {
    private final RepositoryPagamento repositoryPagamento;

    @Scheduled(fixedRate = 120000L)
    public void deleteFailedPayments() {
        long start = System.currentTimeMillis();
        log.info("Removing all failed payments...");
        int amountRemovedPayments = 0;
        Collection<Pagamento> failedPayments = repositoryPagamento.findWhereStatoRifiutato();

        for (Pagamento p : failedPayments) {
            repositoryPagamento.deleteById(p.getIdPagamento());
            log.debug("Removed payment with id={}", p.getIdPagamento());
            amountRemovedPayments++;
        }
        log.info("Job deleteFailedPayments completed. removed={} duration={}ms",
                amountRemovedPayments,
                System.currentTimeMillis() - start);
    }
}
