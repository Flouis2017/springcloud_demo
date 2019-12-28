package com.flouis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zipkin/client")
public class ZipkinClientHandler {

	@Value("${server.port}")
	private String port;

	@GetMapping("/port")
	public String port(){
		return this.port;
	}

}
