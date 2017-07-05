package org.eureka.consumer.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * 通过@FeignClient定义的接口来统一的生成我们需要依赖的微服务接口。而在具体使用的时候就跟调用本地方法一点的进行调用即可
 */
@FeignClient("eureka-client")//使用@FeignClient注解来指定这个接口所要调用的服务名称
public interface DcClient {

	@GetMapping("/dc")//接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
	public String consumer();
}
