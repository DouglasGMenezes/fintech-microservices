package br.com.dgm.msavaliadorcredito.application.controller;

import br.com.dgm.msavaliadorcredito.application.exceptions.ErrorCardRequestException;
import br.com.dgm.msavaliadorcredito.application.mapper.CustomerStatusMapper;
import br.com.dgm.msavaliadorcredito.application.representation.CustomerStatusDTO;
import br.com.dgm.msavaliadorcredito.application.representation.EvaluationDataDTO;
import br.com.dgm.msavaliadorcredito.application.service.CreditEvaluationService;
import br.com.dgm.msavaliadorcredito.domain.model.CardIssuanceProtocol;
import br.com.dgm.msavaliadorcredito.domain.model.CardIssuanceRequestData;
import br.com.dgm.msavaliadorcredito.domain.model.EvaluationCustomer;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;
import br.com.dgm.msavaliadorcredito.infra.mqueue.CardIssuanceRequestPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/aval-credito")
@RequiredArgsConstructor
public class CreditEvaluationController {

    private final CreditEvaluationService creditEvaluationService;
    private final CardIssuanceRequestPublisher cardIssuanceRequestPublisher;

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

    @PostMapping
    public ResponseEntity<EvaluationCustomer> calculateEvaluation(@RequestBody EvaluationDataDTO evaluationData) {
        EvaluationCustomer result = creditEvaluationService.calculateEvaluation(
                evaluationData.taxId(),
                evaluationData.income()
        );
        return ResponseEntity.ok(result);
    }

    public CardIssuanceProtocol cardIssuanceRequest(CardIssuanceRequestData data) {
        try {
            cardIssuanceRequestPublisher.cardResquet(data);
            var protocol = UUID.randomUUID().toString();
            return new CardIssuanceProtocol(protocol);
        } catch (Exception e) {
            throw new ErrorCardRequestException(e.getMessage());
        }
    }

}
