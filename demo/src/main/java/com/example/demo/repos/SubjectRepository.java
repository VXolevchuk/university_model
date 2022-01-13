package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
	public Boolean existsByName(String name);

}
