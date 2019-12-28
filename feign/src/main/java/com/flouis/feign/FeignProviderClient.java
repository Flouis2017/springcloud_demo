package com.flouis.feign;

import com.flouis.entity.Student;
import com.flouis.feign.error.FeignError;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider", fallback = FeignError.class)
@Qualifier("feignProviderClient")
public interface FeignProviderClient {

	@GetMapping("/student/all")
	public Collection<Student> findStudentAll();

	@GetMapping("/student/port")
	public String port();

}
