package com.mrathena.spring.cloud.ribbon.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("ribbon/consumer")
	public String helloConsumer() {
		// 其实是访问服务[EUREKA.CLIENT]的[dc]路径
		return restTemplate.getForEntity("http://EUREKA.CLIENT/dc", String.class).getBody();
	}

}