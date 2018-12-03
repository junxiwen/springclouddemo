package com.miidi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//负载均衡
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix//开启熔断功能
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}


	@Bean //向容器中注册bean实例，并用@LoadBalanced 注解开启负载均衡
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
