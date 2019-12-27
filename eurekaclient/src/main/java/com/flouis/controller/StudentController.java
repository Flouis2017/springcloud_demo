package com.flouis.controller;

import com.flouis.entity.Student;
import com.flouis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Value("${server.port}")
	private String port;


	@GetMapping("/all")
	public Collection<Student> findAll(){
		return this.studentRepository.findAll();
	}

	@GetMapping("/{id}")
	public Student findById(@PathVariable("id") Long id){
		return this.studentRepository.findById(id);
	}

	@PostMapping
	public void add(@RequestBody Student student){
		this.studentRepository.save(student);
	}

	@PutMapping
	public void update(@RequestBody Student student){
		this.studentRepository.save(student);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id){
		this.studentRepository.deleteById(id);
	}

	@GetMapping("/port")
	public String getPort(){
		return "当前服务端口：" + this.port;
	}

}
