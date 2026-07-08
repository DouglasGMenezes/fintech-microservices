package br.com.dgm.msavaliadorcredito.application.controller;

import br.com.dgm.msavaliadorcredito.application.representation.CustomerStatusDTO;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/avalicoes-credito")
public class CreditEvaluationController {

    @GetMapping
    public String status() {
        log.info("Teste status ok.");
        return "OK";
    }

    @GetMapping(value="/custumer-status", params="cpf")
    public ResponseEntity<CustomerStatusDTO> getStatusCustumerByTaxId(@RequestParam("cpf") String taxId) {
        CustomerStatus customerStatus = creditEvaluationService.getCustomerStatus(taxId);
        return null;
    }

}
