package com.miidi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
	//配置文件命名规则
	//{application}-{profile}.yml 或者{application}-{profile}.properties
	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
