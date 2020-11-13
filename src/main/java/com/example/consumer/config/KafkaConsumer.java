package com.example.consumer.config;

import com.example.consumer.config.domain.User;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.AbstractKafkaHeaderMapper;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {

    @KafkaListener(topics = "message",groupId = "group_id")
    public  void consume(String message){
        System.out.println("Messages are: "+message);
    }

    @KafkaListener(topics = "json3",groupId = "group_json", containerFactory = "factoryJson")
    public  void consumeJson(User user){
        try{
            System.out.println("Messages are: "+user);
        }catch (Exception ex){

        }

    }


}
