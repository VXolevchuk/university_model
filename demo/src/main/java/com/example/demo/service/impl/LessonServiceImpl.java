package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Lesson;
import com.example.demo.dto.LessonDTO;
import com.example.demo.repos.LessonRepository;
import com.example.demo.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService{
	private final LessonRepository lessonRepository;

	public LessonServiceImpl(LessonRepository lessonRepository) {
		super();
		this.lessonRepository = lessonRepository;
	}

	@Override
	@Transactional
	public void addLesson(LessonDTO lessonDTO) {
		if(lessonRepository.existsByTimeAndType(lessonDTO.getTime(), lessonDTO.getType()))
			return;
		Lesson lesson = Lesson.fromDTO(lessonDTO);
		lessonRepository.save(lesson);
		
	}

	@Override
	@Transactional
	public void addLessons(List<LessonDTO> lessonDTOs) {
		lessonDTOs.forEach((x) -> {
			if(lessonRepository.existsByTimeAndType(x.getTime(), x.getType())) {
				
			} else {
				Lesson lesson = Lesson.fromDTO(x);
				lessonRepository.save(lesson);
			}
		});
	}

	@Override
	@Transactional(readOnly = true)
	public LessonDTO getLesson(Long id) {
		Lesson lesson = lessonRepository.getById(id);
		return lesson.toDTO();
	}

	@Override
	@Transactional(readOnly = true)
	public List<LessonDTO> getAllLessons() {
		List<Lesson> lessons = lessonRepository.findAll();
		List<LessonDTO> lessonDTOs = new ArrayList<LessonDTO>();
		lessons.forEach((x) -> {
			LessonDTO lessonDTO = x.toDTO();
			lessonDTOs.add(lessonDTO);
		});
		return lessonDTOs;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<LessonDTO> getTodayLessons(Date date, Long groupId) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(date);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR, 0);
		Date from = calendar.getTime();
		
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date to = calendar.getTime();
		
		return lessonRepository.getTodayLessons(from, to, groupId);
	}

	@Override
	@Transactional
	public void deleteLesson(Long id) {
		lessonRepository.deleteById(id);	
	}

	@Override
	@Transactional
	public void deleteLessons(List<Long> ids) {
		ids.forEach((x) -> {
			lessonRepository.deleteById(x);
		});	
	}
	
	

}
