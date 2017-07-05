package org.eureha.client.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
