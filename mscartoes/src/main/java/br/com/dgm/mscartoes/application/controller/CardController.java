package br.com.dgm.mscartoes.application.controller;

import br.com.dgm.mscartoes.application.mapper.CardMapper;
import br.com.dgm.mscartoes.application.representation.CardCustomerRS;
import br.com.dgm.mscartoes.application.representation.CardRQ;
import br.com.dgm.mscartoes.application.representation.CardRS;
import br.com.dgm.mscartoes.application.service.CardCustomerService;
import br.com.dgm.mscartoes.application.service.CardService;
import br.com.dgm.mscartoes.domain.model.Card;
import br.com.dgm.mscartoes.domain.model.CardCustomer;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cartoes")
@Slf4j
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardCustomerService cardCustomerService;

    @GetMapping("/status")
    public String status() {
        log.info("# Teste status OK ");
        return "OK";
    }

    @PostMapping
    public ResponseEntity<CardRS> create(@RequestBody CardRQ rq) {
        Card card = CardMapper.toEntity(rq);
        Card savedCard = cardService.save(card);
        CardRS rs = CardMapper.toDTO(savedCard);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/card-list")
    public ResponseEntity<List<CardRS>> getCardListByIncome(@RequestParam("income") BigDecimal income) {
        List<Card> list = cardService.getCardIncome(income);
        List<CardRS> rs = CardMapper.toListRsDTO(list);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/{taxId}")
    public ResponseEntity<List<CardCustomerRS>> getCardCustomerByTaxId(@PathVariable("taxId") String taxId) {
        List<CardCustomer> list = cardCustomerService.getByTaxId(taxId);
        List<CardCustomerRS> rs = CardMapper.toListCardCustomerDTO(list);
        return ResponseEntity.ok(rs);
    }

}
