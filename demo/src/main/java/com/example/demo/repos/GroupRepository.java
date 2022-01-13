package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Group;

public interface GroupRepository extends JpaRepository<Group, Long>{
	public Boolean existsByNumber(Integer number);

}
