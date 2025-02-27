package com.learning.springbootkafka.kafka;

import com.learning.springbootkafka.Payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    public  static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "javaBuilderJson", groupId = "myGroup")
    public void Consume(User user){
        LOGGER.info(String.format(" Json message consumed : %s",user));
    }
}
