package it.itsacademy.gestionepagamentirestclient.messaging;

import it.itsacademy.gestionepagamentirestclient.dto.CreaPagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.dto.PagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.mapper.PagamentoMapper;
import it.itsacademy.gestionepagamentirestclient.service.PagamentoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PagatoreOrdini {
    private final PagamentoServiceImpl pagamentoService;
    private final RabbitTemplate rabbitTemplate;
    private final PagamentoMapper mapper;

    // RabbitListener serve a dire: aspetta un messaggio da questa coda. Quando arriva esegui questo metodo
    @RabbitListener(queues = "payments.order.queue")
    public void riceviRichiestaPagamento(CreaPagamentoDTO pagamentoRichiesto) {
        // Passi il DTO intero al service
        pagamentoService.paga(pagamentoRichiesto);
    }
}
