package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Course;
import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.FacultyDTO;
import com.example.demo.repos.CourseRepository;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	private final CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	@Transactional
	public void addCourse(CourseDTO courseDTO) {
		if(courseRepository.existsByName(courseDTO.getName()))
			return;
		Course course = Course.fromDTO(courseDTO);
		courseRepository.save(course);
	}

	@Override
	@Transactional
	public void addCourses(List<CourseDTO> courseDTOs) {
		courseDTOs.forEach((x) -> {
		    if(courseRepository.existsByName(x.getName())) {
				
			} else {
				Course course = Course.fromDTO(x);
				courseRepository.save(course);
			}
			});
	}

	@Override
	@Transactional(readOnly = true)
	public CourseDTO getCourse(Long id) {
		Course course = courseRepository.getById(id);
		return course.toDTO();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CourseDTO> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
		List<CourseDTO> courseDTOs = new ArrayList<CourseDTO>();
		courses.forEach((x) -> {
			CourseDTO courseDTO = x.toDTO();
			courseDTOs.add(courseDTO);		
		});
		return courseDTOs;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CourseDTO> getFacultyCourses(FacultyDTO faculty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);	
	}

	@Override
	@Transactional
	public void deleteCourses(List<Long> ids) {
		ids.forEach((x) -> {
			courseRepository.deleteById(x);
		});
	}
	
	

}
