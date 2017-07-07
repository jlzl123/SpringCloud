package org.eureka.consumer.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("config-client")//调用配置客户端服务获取配置信息
public interface PropertiesService {

	@GetMapping("/p")
	public String getPort();
}
