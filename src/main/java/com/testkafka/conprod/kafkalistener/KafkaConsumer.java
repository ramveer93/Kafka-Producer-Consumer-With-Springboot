package com.testkafka.conprod.kafkalistener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.testkafka.conprod.vo.EmployeeVo;
/**
 * 
 * @author sramveer
 *
 */
@Service
public class KafkaConsumer {
	
	@KafkaListener(topics="simple_string",groupId ="group_string")
	public void consume(String message) {
		System.out.println("got the message from kafka: "+message);
	}

	
	@KafkaListener(topics  ="employee",groupId = "group_json",containerFactory = "kafkaEmployeeContainerFactory")
	public void consumeJson(EmployeeVo employee) {
		System.out.println("got emp message-----> "+employee.toString());
	}
}
