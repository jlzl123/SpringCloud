package org.api.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy//注解开启Zuul服务网关
@SpringCloudApplication//它整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker等
public class GatewayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayApplication.class).web(true).run(args);
	}
}
