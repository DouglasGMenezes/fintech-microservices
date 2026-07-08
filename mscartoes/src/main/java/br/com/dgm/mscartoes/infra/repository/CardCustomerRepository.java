package br.com.dgm.mscartoes.infra.repository;

import br.com.dgm.mscartoes.domain.model.CardCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardCustomerRepository extends JpaRepository<CardCustomer,Long> {
    List<CardCustomer> findByTaxId(String taxId);
}
