package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>{
	public Boolean existsByNumber(Long number);

}
