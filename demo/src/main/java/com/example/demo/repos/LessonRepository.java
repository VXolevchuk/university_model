package com.example.demo.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Lesson;
import com.example.demo.Model.LessonType;
import com.example.demo.dto.LessonDTO;


public interface LessonRepository extends JpaRepository<Lesson, Long>{
	public Boolean existsByTimeAndType(Date time, LessonType type);
	
	@Query("SELECT NEW com.example.demo.dto.LessonDTO(l.time, l.classroom.number, l.type, l.subject.name)"
			+ "FROM Lesson l JOIN l.groups g WHERE g.id =:id AND l.date >= :from AND l.date < :to")
	public List<LessonDTO> getTodayLessons(@Param("from") Date from,
			                               @Param("to") Date to, Long id);

}
