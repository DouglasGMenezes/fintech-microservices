package br.com.dgm.msavaliadorcredito.infra.mqueue;

import br.com.dgm.msavaliadorcredito.domain.model.CardIssuanceRequestData;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CardIssuanceRequestPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueCardIssuance;

    public void cardResquet(CardIssuanceRequestData data) {

    }

}
