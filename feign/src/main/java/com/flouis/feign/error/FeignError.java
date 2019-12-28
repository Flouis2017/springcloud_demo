package com.flouis.feign.error;

import com.flouis.entity.Student;
import com.flouis.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Qualifier("feignError")
public class FeignError implements FeignProviderClient {
	@Override
	public Collection<Student> findStudentAll() {
		return null;
	}

	@Override
	public String port() {
		return "服务器维护中...";
	}
}
