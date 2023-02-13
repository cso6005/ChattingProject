package io.csy.chat.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.csy.chat.config.KafkaProducer;
import io.csy.chat.model.dto.MessageDTO;

@RestController
@RequestMapping(value = "chatting")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KafkaController {
	
	@Autowired
    private KafkaProducer producer;


    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody MessageDTO message) throws InterruptedException, ExecutionException {
    	
    	System.out.println(message);
        producer.sendMessage(message);

    }
    
//    @MessageMapping("/getMessage")
//    @SendTo("/topic/group")
//    public MessageDTO broadcastGroupMessage(@Payload MessageDTO message) {
//    
//    	return message;
//   
//    }
    
}
