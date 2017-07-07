package org.eureha.client.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DcController {
	
	private final Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient discoveryClient;//通过DiscoveryClient对象，在日志中打印出服务实例的相关内容。
    
	@RequestMapping(value="/dc")
	public String dc(){
		String services="eclipse services:"+discoveryClient.getServices();//获取了当前客户端缓存的所有服务清单
		log.info(services);
		return services;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@RequestParam("a")String a,@RequestParam("b")String b){
		int A=Integer.valueOf(a);
		int B=Integer.valueOf(b);
		return String.valueOf(A+B);
	}
}
