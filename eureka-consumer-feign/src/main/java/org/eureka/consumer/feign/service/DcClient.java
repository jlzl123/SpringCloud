package org.eureka.consumer.feign.service;

import org.eureka.consumer.feign.fallback.DcClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * 通过@FeignClient定义的接口来统一的生成我们需要依赖的微服务接口。而在具体使用的时候就跟调用本地方法一点的进行调用即可
 */
//使用@FeignClient注解来指定这个接口所要调用的服务名称,如过开启了断路器，通过fallback参数指定熔断后的回调类，该回调类实现当前接口
@FeignClient(value="eureka-client",fallback=DcClientHystrix.class)
public interface DcClient {

	@GetMapping("/dc")//接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
	public String consumer();
}
