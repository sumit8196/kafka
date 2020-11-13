package com.sumit.resources;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.sumit.model.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/kafka")
public class UserResource {
    @Autowired
   KafkaTemplate<String, String> template;

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;
    final static String TOPIC = "message";

    final static String TOPIC_JSON = "json3";

    @GetMapping("/publish/{message}")
    public String hello(@PathVariable("message") final String message) {
        template.send(TOPIC, message);


        return "Published Successfuly";
    }
    @GetMapping("/publish2/{name}")
    public String hello2(@PathVariable("name") final String name) {
       User user=new User(name,"Developer", 700000L);

       kafkaTemplate.send(TOPIC_JSON,user);


        return "Published Successfully";
    }

}
