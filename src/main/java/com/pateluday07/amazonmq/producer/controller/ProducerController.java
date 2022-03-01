package com.pateluday07.amazonmq.producer.controller;

import com.pateluday07.amazonmq.producer.dto.MessageDTO;
import com.pateluday07.amazonmq.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/messages")
@Log4j2
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping
    public ResponseEntity<HttpStatus> sendMessage(@Valid @RequestBody MessageDTO messageDTO) {
        log.info("Sending {}", messageDTO);
        producerService.sendTextMessage(messageDTO);
        log.info("{} sent!", messageDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
