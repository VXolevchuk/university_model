package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Lesson;
import com.example.demo.dto.LessonDTO;
import com.example.demo.repos.LessonRepository;
import com.example.demo.service.LessonService;

public class LessonServiceImpl implements LessonService{
	private final LessonRepository lessonRepository;

	public LessonServiceImpl(LessonRepository lessonRepository) {
		super();
		this.lessonRepository = lessonRepository;
	}

	@Override
	public void addLesson(LessonDTO lessonDTO) {
		if(lessonRepository.existsByTimeAndType(lessonDTO.getTime(), lessonDTO.getType()))
			return;
		Lesson lesson = Lesson.fromDTO(lessonDTO);
		lessonRepository.save(lesson);
		
	}

	@Override
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
	public LessonDTO getLesson(Long id) {
		Lesson lesson = lessonRepository.getById(id);
		return lesson.toDTO();
	}

	@Override
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
	public void deleteLesson(Long id) {
		lessonRepository.deleteById(id);	
	}

	@Override
	public void deleteLessons(List<Long> ids) {
		ids.forEach((x) -> {
			lessonRepository.deleteById(x);
		});	
	}
	
	

}
