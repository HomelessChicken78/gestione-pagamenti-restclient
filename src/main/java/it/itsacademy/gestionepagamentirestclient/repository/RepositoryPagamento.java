package it.itsacademy.gestionepagamentirestclient.repository;

import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryPagamento extends JpaRepository<Pagamento, UUID> {
}
