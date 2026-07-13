package br.com.dgm.msavaliadorcredito.application.controller;

import br.com.dgm.msavaliadorcredito.application.mapper.CustomerStatusMapper;
import br.com.dgm.msavaliadorcredito.application.representation.CustomerStatusDTO;
import br.com.dgm.msavaliadorcredito.application.service.CreditEvaluationService;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/aval-credito")
@RequiredArgsConstructor
public class CreditEvaluationController {

    private final CreditEvaluationService creditEvaluationService;

    @GetMapping
    public String status() {
        log.info("Teste status ok.");
        return "OK";
    }

    @GetMapping(value="/custumer-status", params="cpf")
    public ResponseEntity<CustomerStatusDTO> getStatusCustumerByTaxId(@RequestParam("cpf") String taxId) {
        CustomerStatus customerStatus = creditEvaluationService.getCustomerStatus(taxId);
        CustomerStatusDTO response = CustomerStatusMapper.toDto(customerStatus);
        return ResponseEntity.ok(response);
    }

}
