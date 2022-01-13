package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Course;
import com.example.demo.Model.Student;
import com.example.demo.dto.StudentDTO;
import com.example.demo.repos.CourseRepository;
import com.example.demo.repos.StudentRepository;
import com.example.demo.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;

	public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	@Override
	public void addStudent(StudentDTO studentDTO) {
		if(studentRepository.existsByName(studentDTO.getName()))
			return;
		Student student = Student.fromDTO(studentDTO);
		Course course = courseRepository.getByName(studentDTO.getCourseName());
		student.setCourse(course);
		studentRepository.save(student);
		
	}

	@Override
	public void addStudents(List<StudentDTO> studentDTOs) {
		studentDTOs.forEach((x) -> {
		    if(studentRepository.existsByName(x.getName())) {
			
		    } else {
		    	Student student = Student.fromDTO(x);
				Course course = courseRepository.getByName(x.getCourseName());
				student.setCourse(course);
				studentRepository.save(student);
		    }
		});
		
	}

	@Override
	public StudentDTO getStudent(Long id) {
		Student student = studentRepository.getById(id);
		return student.toDTO();
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
		students.forEach((x) -> {
			StudentDTO studentDTO = x.toDTO();
			studentDTOs.add(studentDTO);
		});
		return studentDTOs;
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public void deleteStudents(List<Long> ids) {
		ids.forEach((x) -> {
			studentRepository.deleteById(x);
		});			
	}
	
	

}
