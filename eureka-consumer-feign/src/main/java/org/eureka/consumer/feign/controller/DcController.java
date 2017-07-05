package org.eureka.consumer.feign.controller;

import org.eureka.consumer.feign.service.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

	@Autowired
	private DcClient dcClient;
	
	@GetMapping("/consumer")
	public String consumer(){
		return dcClient.consumer();
	}
}
