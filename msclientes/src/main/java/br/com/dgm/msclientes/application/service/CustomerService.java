package br.com.dgm.msclientes.application.service;

import br.com.dgm.msclientes.application.representation.CustomerRequestDTO;
import br.com.dgm.msclientes.domain.model.Customer;
import br.com.dgm.msclientes.infra.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public Customer update(Long id, CustomerRequestDTO dto) {
        Customer customer = validationId(id);
        customer.setName(dto.name());
        customer.setAge(dto.age());
        customer.setTaxId(dto.taxId());
        return customerRepository.save(customer);
    }

    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> getByTaxId(String taxId) {
        return customerRepository.findByTaxId(taxId);
    }

    private Customer validationId(Long id) {
        return getById(id).orElseThrow(() -> new NotFoundException("Client not found - id: " + id.toString()));
    }

}
