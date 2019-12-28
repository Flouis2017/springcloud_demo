package com.flouis.controller;

import com.flouis.feign.FeignProviderClient;
import com.flouis.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
public class HystrixHandler {

	@Autowired
	@Qualifier("feignProviderClient")
	private FeignProviderClient feignProviderClient;

	@GetMapping("/student")
	public JsonResult findStudentAll(){
		return JsonResult.success(this.feignProviderClient.findStudentAll());
	}

	@GetMapping("/port")
	public JsonResult port(){
		return JsonResult.success(this.feignProviderClient.port());
	}

}
