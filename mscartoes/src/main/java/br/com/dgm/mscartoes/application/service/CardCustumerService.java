package br.com.dgm.mscartoes.application.service;

import br.com.dgm.mscartoes.domain.model.CardCustumer;
import br.com.dgm.mscartoes.infra.repository.CardCustumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardCustumerService {

    private final CardCustumerRepository repository;

    public List<CardCustumer> getByTaxId(String taxId) {
        return repository.findByTaxId(taxId);
    }

}
