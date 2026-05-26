package it.itsacademy.gestionepagamentirestclient.mapper;

import it.itsacademy.gestionepagamentirestclient.dto.PagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    PagamentoDTO toDTO(Pagamento salvato);

    Collection<PagamentoDTO> toDTO(Collection<Pagamento> byIdOrdine);
}
