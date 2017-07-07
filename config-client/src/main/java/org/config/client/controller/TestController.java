package org.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${profile:qwer}")
	private String profile;
	@Value("${server.port}")//port赋值abcdfe
	private String port;
	@Value("${spring.cloud.consul.port}")//注入从配置中心取得的值
	private String p;
	
	@GetMapping("/get")
	public String get(){
		return profile;
	}
	
	@GetMapping("/port")
	public String port(){
		return port;
	}
	
	@GetMapping("/p")
	public String p(){
		return p;
	}
	
	@GetMapping("/name")
	public String name(@Value("${spring.application.name}")String name){
		return name;
	}
	
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String getProfile() {
		return profile;
	}
}
