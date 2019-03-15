package com.testkafka.conprod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testkafka.conprod.utils.ResponseUtil;
import com.testkafka.conprod.vo.EmployeeVo;
/**
 * 
 * @author sramveer
 *
 */
@RestController
@RequestMapping("kafka")
public class KafkaProducerConsumerController {

	@Autowired
	private KafkaTemplate<String, EmployeeVo> template;
	private static String TOPIC = "employee";

	@Autowired
	private ResponseUtil responseUtils;

	@RequestMapping(value = "/produce", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseUtil> publishKafkaMessage(@RequestBody EmployeeVo employee) {
		try {
			template.send(TOPIC, employee);
		} catch (Exception ex) {
			return new ResponseEntity<ResponseUtil>(this.responseUtils.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					ex.getMessage(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ResponseUtil>(this.responseUtils.build(HttpStatus.OK.value(),
				"Message successfully published", "Message successfully published"), HttpStatus.OK);
	}
	
}
