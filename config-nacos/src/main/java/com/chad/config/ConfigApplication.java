package com.chad.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ConfigApplication {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);
		while (true) {
			String userName = applicationContext.getEnvironment().getProperty("redis.username");
			String configName = applicationContext.getEnvironment().getProperty("nacos.config");
			System.out.println("userName:" + userName + ";configName:" + configName);
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
