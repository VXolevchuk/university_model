package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.FacultyDTO;

public interface CourseService {
	public void addCourse(CourseDTO courseDTO);
	public void addCourses(List<CourseDTO> courseDTOs);
	public CourseDTO getCourse(Long id);
	public List<CourseDTO> getAllCourses();
	public List<CourseDTO> getFacultyCourses(FacultyDTO faculty);
	public void deleteCourse(Long id);
	public void deleteCourses(List<Long> ids);

}
