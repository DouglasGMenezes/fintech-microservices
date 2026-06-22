package br.com.dgm.mscartoes.application.controller;

import br.com.dgm.mscartoes.application.mapper.CardMapper;
import br.com.dgm.mscartoes.application.representation.CardCustumerRS;
import br.com.dgm.mscartoes.application.representation.CardRequest;
import br.com.dgm.mscartoes.application.representation.CardResponse;
import br.com.dgm.mscartoes.application.service.CardCustumerService;
import br.com.dgm.mscartoes.application.service.CardService;
import br.com.dgm.mscartoes.domain.model.Card;
import br.com.dgm.mscartoes.domain.model.CardCustumer;
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
    private final CardCustumerService cardCustumerService;

    @GetMapping("/status")
    public String status() {
        log.info("# Teste status OK ");
        return "OK";
    }

    @PostMapping
    public ResponseEntity<CardResponse> create(@RequestBody CardRequest rq) {
        Card card = CardMapper.toEntity(rq);
        Card savedCard = cardService.save(card);
        CardResponse rs = CardMapper.toDTO(savedCard);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/card-list")
    public ResponseEntity<List<CardResponse>> getCardListByIncome(@RequestParam("income") BigDecimal income) {
        List<Card> list = cardService.getCardIncome(income);
        List<CardResponse> rs = CardMapper.toListRsDTO(list);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/{taxId}")
    public ResponseEntity<List<CardCustumerRS>> getCardCustumerByTaxId(@PathVariable("taxId") String taxId) {
        List<CardCustumer> list = cardCustumerService.getByTaxId(taxId);
        List<CardCustumerRS> rs = CardMapper.toListCardCustumerDTO(list);
        return ResponseEntity.ok(rs);
    }

}
