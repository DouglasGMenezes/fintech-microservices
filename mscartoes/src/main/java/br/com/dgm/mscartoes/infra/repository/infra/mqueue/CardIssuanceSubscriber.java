package br.com.dgm.mscartoes.infra.repository.infra.mqueue;

import br.com.dgm.mscartoes.domain.model.Card;
import br.com.dgm.mscartoes.domain.model.CardCustomer;
import br.com.dgm.mscartoes.domain.model.CardIssuanceRequestData;
import br.com.dgm.mscartoes.infra.repository.CardCustomerRepository;
import br.com.dgm.mscartoes.infra.repository.CardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class CardIssuanceSubscriber {

    private final CardRepository cardRepository;
    private final CardCustomerRepository cardCustomerRepository;

    @RabbitListener(queues="${mq.queues.card-issuance}")
    public void receiveIssuanceRequest(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            CardIssuanceRequestData data = mapper.readValue(payload, CardIssuanceRequestData.class);

            Card card = cardRepository.findById(data.getCardId()).orElseThrow();

            CardCustomer cardCustomer = new CardCustomer();
            cardCustomer.setCard(card);
            cardCustomer.setTaxId(data.getTaxId());
            cardCustomer.setApprovedLimit(data.getAvailableLimit());
            cardCustomerRepository.save(cardCustomer);

        } catch (Exception e) {
            log.error("Erro ao receber solicitação de emissão de cartão: {}", e.getMessage());
        }
    }

}
