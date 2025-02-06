package com.learning.springbootkafka.controller;

import com.learning.springbootkafka.Payload.User;
import com.learning.springbootkafka.kafka.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> PublishJsonMessage(@RequestBody User user){
        jsonKafkaProducer.SendMessage(user);
        return ResponseEntity.ok("Json Message sent to Kafka Topic");
    }
}
