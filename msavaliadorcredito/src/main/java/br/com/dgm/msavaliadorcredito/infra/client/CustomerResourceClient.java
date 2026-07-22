package br.com.dgm.msavaliadorcredito.infra.client;

import br.com.dgm.msavaliadorcredito.application.representation.CustomerDataDTO;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerData;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="msclientes", path="/clientes")
public interface CustomerResourceClient {

    @GetMapping(params="taxId")
    ResponseEntity<CustomerResponseDTO> getCustomerByTaxId(@RequestParam("taxId") String taxId);

}
