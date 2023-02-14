package io.csy.chat.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import io.csy.chat.model.dto.MessageDTO;

@Service
public class KafkaConsumer {
	
    @Value("${spring.kafka.topic}")
    private String topic;
    
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
    
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// 기본
    @KafkaListener(topics = "chatting-topic", groupId = "sso")
    public void consume(MessageDTO message) throws IOException {
    	
//    	LOGGER.info("### consumer message : {}", message);
    	
        System.out.println(String.format("Consumed message : %s", message.toString()));
        
    }
    
    /**
     * Kafka Listener
     * Kafka에서 메시지를 읽어들이는 역할
     *
     * <개념>
     * Topic: 메시지 데이터의 구분을 할 수 있는 논리적 개념
     * Offset: Kafka Message의 고유번호. consumer에서 메시지를 어디까지 읽었는지 확인하는 용도로 쓰임
     *
     * <log 예시>
     * ### record: ConsumerRecord(topic = dev-topic, partition = 0, leaderEpoch = 0, offset = 1, CreateTime = 1649170434791, serialized key size = -1, serialized value size = 13, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = kafka message)
     * ### topic: dev-topic, value: kafka message, offset: 1
     * @param record
     */
	
//    @KafkaListener(topics = "chatting-topic")
//    public void messageListener(ConsumerRecord<String, MessageDTO> record, Acknowledgment acknowledgment) {
//        LOGGER.info("### record: " + record.toString());
//        LOGGER.info("### topic: " + record.topic() + ", value: " + record.value().toString() + ", offset: " + record.offset());
//        
//        System.out.println("message : " + record.value().toString() );
//
//        // kafka 메시지 읽어온 곳까지 commit. (이 부분을 하지 않으면 메시지를 소비했다고 commit 된 것이 아니므로 계속 메시지를 읽어온다)
//        acknowledgment.acknowledge();
//    }
}
