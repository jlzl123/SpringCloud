package org.eureka.consumer.feign.fallback;

import org.eureka.consumer.feign.service.DcClient;
import org.springframework.stereotype.Component;

/*
 * 回调类，实现@FeignClient的接口，此时实现的方法就是对应@FeignClient接口中映射的fallback函数。
 */
@Component
public class DcClientHystrix implements DcClient{

	@Override
	public String consumer() {
		// TODO Auto-generated method stub
		return "调用失败，执行回调函数";
	}

}
