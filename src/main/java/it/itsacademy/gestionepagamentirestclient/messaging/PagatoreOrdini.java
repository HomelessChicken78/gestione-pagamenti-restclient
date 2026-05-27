package it.itsacademy.gestionepagamentirestclient.messaging;

import it.itsacademy.gestionepagamentirestclient.dto.CreaPagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.dto.PagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.mapper.PagamentoMapper;
import it.itsacademy.gestionepagamentirestclient.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PagatoreOrdini {
    private final PagamentoService pagamentoService;
    private final RabbitTemplate rabbitTemplate;
    private final PagamentoMapper mapper;

    // RabbitListener serve a dire: aspetta un messaggio da questa coda. Quando arriva esegui questo metodo
    @RabbitListener(queues = "payments.order.queue")
    public void riceviRichiestaPagamento(CreaPagamentoDTO pagamentoRichiesto) {
        // Passi il DTO intero al service
        PagamentoDTO esito = pagamentoService.paga(pagamentoRichiesto);

        // Se il pagamento è andato a buon fine la routing key sarà payments.accettato, altrimenti sarà payments.rifiutato.
        // L'exchange si occuperà di inviarlo nella queue corretta.
        rabbitTemplate.convertAndSend("payments.exchange",
                "payments." + esito.getStatoPagamento().name().toLowerCase(),
                esito.getIdOrdine()); // Invia solo l'id dell'ordine a cui è stato effettuato il pagamento
    }
}
