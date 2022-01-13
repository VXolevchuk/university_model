package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{
	public Boolean existsByName(String name);

}
