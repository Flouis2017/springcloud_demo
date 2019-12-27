package com.flouis.controller;

import com.flouis.entity.Student;
import com.flouis.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/student")
	public JsonResult findStudentAll(){
		Collection studentList = this.restTemplate.getForObject("http://localhost:8010/student/all", Collection.class);
		return JsonResult.success(studentList);
	}

	@GetMapping("/student2")
	public JsonResult findStudentAll2(){
		Collection studentList = this.restTemplate.getForEntity("http://localhost:8010/student/all", Collection.class).getBody();
		return JsonResult.success(studentList);
	}

	@GetMapping("/student/{id}")
	public JsonResult findStudentById(@PathVariable("id") Long id){
		Student student = this.restTemplate.getForObject("http://localhost:8010/student/{id}", Student.class, id);
		return JsonResult.success(student);
	}

	@GetMapping("/student2/{id}")
	public JsonResult findStudentById2(@PathVariable("id") Long id){
		Student student = this.restTemplate.getForEntity("http://localhost:8010/student/{id}", Student.class, id).getBody();
		return JsonResult.success(student);
	}

	@PostMapping("/student")
	public JsonResult addStudent(@RequestBody Student student){
		try {
			this.restTemplate.postForEntity("http://localhost:8010/student", student, null);
			return JsonResult.success();
		} catch (Exception e){
			e.printStackTrace();
			return JsonResult.fail();
		}
	}

	@PutMapping("/student")
	public JsonResult updateStudent(@RequestBody Student student){
		try {
			this.restTemplate.put("http://localhost:8010/student", student);
			return JsonResult.success();
		} catch (Exception e){
			e.printStackTrace();
			return JsonResult.fail();
		}
	}

	@DeleteMapping("/student/{id}")
	public JsonResult deleteStudentById(@PathVariable("id") Long id){
		try {
			this.restTemplate.delete("http://localhost:8010/student/{id}", id);
			return JsonResult.success();
		} catch (Exception e){
			e.printStackTrace();
			return JsonResult.fail();
		}
	}


}
