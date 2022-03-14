package com.pateluday07.amazonmq.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pateluday07.amazonmq.producer.component.Producer;
import com.pateluday07.amazonmq.producer.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    @Value("${activemq.queue.demo}")
    private String demoQueue;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Producer producer;

    @Override
    public void sendTextMessage(MessageDTO message) {
        log.info("Sending {} to producer.", message);
        try {
            producer.sendMessage(demoQueue, objectMapper.writeValueAsString(message));
            log.info("{} sent!", message);
        } catch (JsonProcessingException e) {
            log.error("Error while converting object to JSON", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid message data");
        }
    }
}
