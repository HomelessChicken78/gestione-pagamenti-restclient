package it.itsacademy.gestionepagamentirestclient.repository;

import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.UUID;

public interface RepositoryPagamento extends JpaRepository<Pagamento, UUID> {
    Collection<Pagamento> findByIdOrdine(UUID idOrdine);

    @Query("SELECT p FROM Pagamento AS p WHERE p.statoPagamento = 'RIFIUTATO'")
    Collection<Pagamento> findWhereStatoRifiutato();
}
