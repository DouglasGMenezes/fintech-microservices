package br.com.dgm.mscartoes.infra.repository.infra.mqueue;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class CardIssuanceSubscriber {

    @RabbitListener(queues="${mq.queues.card-issuance}")
    public void receiveIssuanceRequest(@Payload String payload) {
        System.out.println(payload);
    }

}
