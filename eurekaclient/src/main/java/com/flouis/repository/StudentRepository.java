package com.flouis.repository;

import com.flouis.entity.Student;

import java.util.Collection;

public interface StudentRepository {

	public Collection<Student> findAll();

	public Student findById(Long id);

	public void save(Student student);

	public void deleteById(Long id);

}
