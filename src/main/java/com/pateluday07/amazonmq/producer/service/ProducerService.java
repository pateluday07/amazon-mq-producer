package com.pateluday07.amazonmq.producer.service;

import com.pateluday07.amazonmq.producer.dto.MessageDTO;

public interface ProducerService {

    public void sendTextMessage(MessageDTO message);
}
