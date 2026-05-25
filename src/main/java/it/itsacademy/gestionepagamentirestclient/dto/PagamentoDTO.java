package it.itsacademy.gestionepagamentirestclient.dto;

import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PagamentoDTO {
    private UUID idPagamento;

    private UUID idOrdine;
    private Double totale = 0.0;
    private LocalDate dataPagamento = LocalDate.now();
    private StatoPagamento statoPagamento;

    public enum StatoPagamento {
        RIFIUTATO, ACCETTATO
    }
}
