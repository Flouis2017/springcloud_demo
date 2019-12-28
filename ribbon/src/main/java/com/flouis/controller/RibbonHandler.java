package com.flouis.controller;

import com.flouis.entity.Student;
import com.flouis.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/student")
	public JsonResult findStudentAll(){
		Collection<Student> all = this.restTemplate.getForObject("http://provider/student/all", Collection.class);
		return JsonResult.success(all);
	}

	@RequestMapping("/port")
	public JsonResult port(){
		String port = this.restTemplate.getForObject("http://provider/student/port", String.class);
		return JsonResult.success(port);
	}

}
