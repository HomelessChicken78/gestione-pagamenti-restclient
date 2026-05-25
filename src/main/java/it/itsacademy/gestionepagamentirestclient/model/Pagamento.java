package it.itsacademy.gestionepagamentirestclient.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Pagamento {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id private UUID idOrdine;

    private StatoPagamento statoPagamento;

    public enum StatoPagamento {
        RIFIUTATO, ACCETTATO
    }
}
