package it.itsacademy.gestionepagamentirestclient.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Pagamento {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id private UUID idPagamento;

    @Column(nullable = false) private UUID idOrdine;

    @Column(nullable = false) private Double totale = 0.0;
    @Column(nullable = false) private LocalDate dataPagamento = LocalDate.now();//
    @Column(nullable = false) private StatoPagamento statoPagamento = StatoPagamento.RIFIUTATO;

    public enum StatoPagamento {
        RIFIUTATO, ACCETTATO
    }
}
