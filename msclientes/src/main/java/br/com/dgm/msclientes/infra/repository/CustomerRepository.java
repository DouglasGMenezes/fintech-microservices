package br.com.dgm.msclientes.infra.repository;

import br.com.dgm.msclientes.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByTaxId(String taxId);
}
