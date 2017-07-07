package org.eureka.consumer.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ComputeService {

	@Autowired
	private RestTemplate restTemplate;
	
	//注解实现断路器回调，当调用服务失败后，调用addServiceFallback方法
	@HystrixCommand(fallbackMethod="addServiceFallback")
	public String addService(){
		return restTemplate.getForObject("http://eureka-client/add?a=10&b=20", String.class);
	}
	
	@SuppressWarnings("unused")
	private String addServiceFallback(){
		return "error";
	}
}
