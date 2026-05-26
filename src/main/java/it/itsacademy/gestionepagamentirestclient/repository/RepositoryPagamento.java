package it.itsacademy.gestionepagamentirestclient.repository;

import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.UUID;

public interface RepositoryPagamento extends JpaRepository<Pagamento, UUID> {
    @Enumerated(EnumType.STRING)
    Collection<Pagamento> findByIdOrdine(UUID idOrdine);
}
