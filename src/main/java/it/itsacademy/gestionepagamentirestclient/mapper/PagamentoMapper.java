package it.itsacademy.gestionepagamentirestclient.mapper;

import it.itsacademy.gestionepagamentirestclient.dto.PagamentoDTO;
import it.itsacademy.gestionepagamentirestclient.model.Pagamento;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    PagamentoDTO toDTO(Pagamento salvato);
}
