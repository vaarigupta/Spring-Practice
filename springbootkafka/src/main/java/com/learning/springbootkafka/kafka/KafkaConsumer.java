package com.learning.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "javaBuilder", groupId = "myGroup")
    public void Consume(String message){
        LOGGER.info(String.format("Message consumed -> %s",message));
    }
}
