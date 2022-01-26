package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.LessonDTO;
import com.example.demo.dto.StudentDTO;

public interface LessonService {
	public void addLesson(LessonDTO lessonDTO);
	public void addLessons(List<LessonDTO> lessonDTOs);
	public LessonDTO getLesson(Long id);
	public List<LessonDTO> getAllLessons();
	public void deleteLesson(Long id);
	public void deleteLessons(List<Long> ids);
	
	public List<LessonDTO> getTodayLessons(Date date, Long groupId);

}
