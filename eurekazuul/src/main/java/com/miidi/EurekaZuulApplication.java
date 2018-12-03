package com.miidi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/****
 * zuul 它包含了对请求的  路由、过滤 两个功能，
 * 路由：负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础；
 * 过滤器：负责对请求的处理过程进行干预，是实现请求校验、服务聚合等功能的基础。
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class EurekaZuulApplication {

	public static void main(String[] args) {
		//new SpringApplicationBuilder(EurekaZuulApplication.class).web(true).run(args);
		SpringApplication.run(EurekaZuulApplication.class, args);
	}
}
