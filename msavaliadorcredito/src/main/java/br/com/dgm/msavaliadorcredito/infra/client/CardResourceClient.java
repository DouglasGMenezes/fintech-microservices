package br.com.dgm.msavaliadorcredito.infra.client;

import br.com.dgm.msavaliadorcredito.infra.client.dto.CardCustomerRS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="mscartoes", path="/cartoes")
public interface CardResourceClient {
    @GetMapping("/{taxId}")
    ResponseEntity<List<CardCustomerRS>> getCardCustumerByTaxId(@PathVariable("taxId") String taxId);
}
