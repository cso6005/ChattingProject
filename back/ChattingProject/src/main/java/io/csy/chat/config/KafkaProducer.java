package io.csy.chat.config;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.csy.chat.model.dto.MessageDTO;


@Service
public class KafkaProducer {
	
    @Value("${spring.kafka.topic}")
    private String topic;
    
    @Autowired
    private KafkaTemplate<String, MessageDTO> kafkaTemplate;

    @Transactional
    public void sendMessage(MessageDTO message) throws InterruptedException, ExecutionException {
    	
        
        message.setTimestamp(LocalDateTime.now().toString());
        
        System.out.println("Produce message:" + message.toString());

        
        // 예외 발생 나중에 추가
      
        
        kafkaTemplate.send(topic, message);
        
        System.out.println("들어가짐.");
        
    }
}
