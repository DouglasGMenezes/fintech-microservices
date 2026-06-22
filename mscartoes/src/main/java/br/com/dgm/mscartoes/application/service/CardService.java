package br.com.dgm.mscartoes.application.service;

import br.com.dgm.mscartoes.domain.model.Card;
import br.com.dgm.mscartoes.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> getCardIncome(BigDecimal income) {
        //var incomeBigDecimal = BigDecimal.valueOf();
        return cardRepository.findByIncomeLessThanEqual(income);
    }

}
