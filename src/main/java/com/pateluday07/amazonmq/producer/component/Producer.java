package com.pateluday07.amazonmq.producer.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate jmsTemplate;

    public void sendMessage(final String queueName, final String message) {
        log.info("Sending {} to {} queue.", message, queueName);
        jmsTemplate.convertAndSend(queueName, message);
        log.info("{} successfully sent to {} queue.", message, queueName);
    }
}
