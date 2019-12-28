package com.flouis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer		// 声明该微服务为配置中心
public class NativeConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NativeConfigServerApplication.class, args);
	}

}
