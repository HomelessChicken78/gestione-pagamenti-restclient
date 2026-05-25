package it.itsacademy.gestionepagamentirestclient.dto;

import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PagamentoDTO {
    private UUID idPagamento;

    private StatoPagamento statoPagamento;

    public enum StatoPagamento {
        RIFIUTATO, ACCETTATO
    }
}
