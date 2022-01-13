package com.example.demo.repos;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Lesson;
import com.example.demo.Model.LessonType;


public interface LessonRepository extends JpaRepository<Lesson, Long>{
	public Boolean existsByTimeAndType(Date time, LessonType type);

}
