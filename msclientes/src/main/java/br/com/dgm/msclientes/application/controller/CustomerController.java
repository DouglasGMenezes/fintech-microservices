package br.com.dgm.msclientes.application.controller;

import br.com.dgm.msclientes.application.mapper.CustomerMapper;
import br.com.dgm.msclientes.application.representation.CustomerRequestDTO;
import br.com.dgm.msclientes.application.representation.CustomerResponseDTO;
import br.com.dgm.msclientes.application.service.CustomerService;
import br.com.dgm.msclientes.domain.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


@RestController
@RequestMapping("/clientes")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/ok")
    public String getOk() {
        log.info("# Get status mscliente");
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerRequestDTO request) {
        Customer customer = CustomerMapper.toEntity(request);
        customerService.create(customer);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("taxId={taxId}")
                .buildAndExpand(customer.getTaxId())//
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params="taxId")
    public ResponseEntity<CustomerResponseDTO> getCustomerByTaxId(@RequestParam("taxId") String taxId) {
        return customerService.getByTaxId(taxId)
                .map(CustomerMapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> editCustomer(@RequestBody CustomerRequestDTO clienteRqDTO, @PathVariable("id") Long id) {
        Customer customer = customerService.update(id, clienteRqDTO);
        return ResponseEntity.ok(CustomerMapper.toRsUpdadeDto(customer));
    }


}
