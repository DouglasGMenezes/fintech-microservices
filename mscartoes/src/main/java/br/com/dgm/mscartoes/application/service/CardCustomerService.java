package br.com.dgm.mscartoes.application.service;

import br.com.dgm.mscartoes.domain.model.CardCustomer;
import br.com.dgm.mscartoes.infra.repository.CardCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardCustomerService {

    private final CardCustomerRepository repository;

    public List<CardCustomer> getByTaxId(String taxId) {
        return repository.findByTaxId(taxId);
    }

}
