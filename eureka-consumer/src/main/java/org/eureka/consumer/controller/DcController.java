package org.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

	@Autowired
	private RestTemplate restTemplate;//利用RestTemplate对象实现对服务提供者接口的调用
	@Autowired 
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/consumer")//注解get请求
	public String dc(){
		//通过loadBalancerClient的choose负载均衡的选出一个eureka-client的服务实例
		ServiceInstance serviceInstance=loadBalancerClient.choose("eureka-client");
		String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}
}
