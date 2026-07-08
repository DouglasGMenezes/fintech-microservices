package br.com.dgm.mscartoes.application.mapper;

import br.com.dgm.mscartoes.application.representation.CardCustomerRS;
import br.com.dgm.mscartoes.application.representation.CardRQ;
import br.com.dgm.mscartoes.application.representation.CardRS;
import br.com.dgm.mscartoes.domain.model.Card;
import br.com.dgm.mscartoes.domain.model.CardCustomer;
import br.com.dgm.mscartoes.domain.model.enuns.CardBrand;
import java.util.List;

public class CardMapper {

    public static Card toEntity(CardRQ rq) {
        Card card = new Card();
        card.setHolderName(rq.holderName());
        card.setCardBrand(CardBrand.from(rq.cardBrand()));
        card.setIncome(rq.income());
        card.setCreditLimit(rq.creditLimit());
        return card;
    }

    public static CardRS toDTO(Card card) {
        return new CardRS(
                card.getId(),
                card.getHolderName(),
                card.getCardBrand().toString(),
                card.getCreditLimit(),
                card.getIncome()
        );
    }

    public static List<CardRS> toListRsDTO(List<Card> cards) {
        return cards.stream()
                .map(CardMapper::toDTO)
                .toList();
    }

    public static CardCustomerRS toCardCustomerDTO(CardCustomer cardCustomer) {
        return new CardCustomerRS(
                cardCustomer.getCard().getHolderName(),
                cardCustomer.getCard().getCardBrand().toString(),
                cardCustomer.getApprovedLimit()
        );
    }

    public static List<CardCustomerRS> toListCardCustomerDTO(List<CardCustomer> cardCustomers) {
        return cardCustomers.stream()
                .map(CardMapper::toCardCustomerDTO)
                .toList();
    }

}
