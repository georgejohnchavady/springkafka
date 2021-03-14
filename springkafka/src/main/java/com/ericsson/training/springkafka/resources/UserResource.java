package com.ericsson.training.springkafka.resources;


import com.ericsson.training.springkafka.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserResource {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    public static final String TOPIC = "user_resource";

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC, new User(name,"Technology", 12000L));
        return "published successfully";
    }
}
