package it.itsacademy.gestionepagamentirestclient.dto;

import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CreaPagamentoDTO {
    private UUID idOrdine; // Dobbiamo necessariamente includerlo qui perchè con AMQ non possiamo passare path variable
    private Double totale;
}
