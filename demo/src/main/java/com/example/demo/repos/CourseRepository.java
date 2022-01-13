package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	public Boolean existsByName(String name);
	public Course getByName(String name);

}
