package br.com.dgm.mscartoes.application.mapper;

import br.com.dgm.mscartoes.application.representation.CardCustumerRS;
import br.com.dgm.mscartoes.application.representation.CardRequest;
import br.com.dgm.mscartoes.application.representation.CardResponse;
import br.com.dgm.mscartoes.domain.model.Card;
import br.com.dgm.mscartoes.domain.model.CardCustumer;
import br.com.dgm.mscartoes.domain.model.enuns.CardBrand;

import java.util.List;

public class CardMapper {

    public static Card toEntity(CardRequest rq) {
        Card card = new Card();
        card.setHolderName(rq.holderName());
        card.setCardBrand(CardBrand.from(rq.cardBrand()));
        card.setIncome(rq.income());
        card.setCreditLimit(rq.creditLimit());
        return card;
    }

    public static CardResponse toDTO(Card card) {
        return new CardResponse(
                card.getId(),
                card.getHolderName(),
                card.getCardBrand().toString(),
                card.getCreditLimit(),
                card.getIncome()
        );
    }

    public static List<CardResponse> toListRsDTO(List<Card> cards) {
        return cards.stream()
                .map(CardMapper::toDTO)
                .toList();
    }

    public static CardCustumerRS toCardCustumerDTO(CardCustumer cardCustumer) {
        return new CardCustumerRS(
                cardCustumer.getCard().getHolderName(),
                cardCustumer.getCard().getCardBrand().toString(),
                cardCustumer.getApprovedLimit()
        );
    }

    public static List<CardCustumerRS> toListCardCustumerDTO(List<CardCustumer> cardCustumers) {
        return cardCustumers.stream()
                .map(CardMapper::toCardCustumerDTO)
                .toList();
    }

}
