package com.ericsson.training.springkafka.listeners;

import com.ericsson.training.springkafka.models.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {
    @KafkaListener(topics = {"user_resource"}, groupId = "admin")
    public void consume(User user){
        System.out.println(user);
    }

}
