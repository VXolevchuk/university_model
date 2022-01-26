package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	public Boolean existsByName(String name);
	public Student getByName(String name);

}
