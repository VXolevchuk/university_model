package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Course;
import com.example.demo.Model.Group;
import com.example.demo.Model.Student;
import com.example.demo.dto.GroupDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.repos.CourseRepository;
import com.example.demo.repos.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;

	public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	@Override
	@Transactional
	public void addStudent(StudentDTO studentDTO) {
		if(studentRepository.existsByName(studentDTO.getName()))
			return;
		Student student = Student.fromDTO(studentDTO);
		Course course = courseRepository.getByName(studentDTO.getCourseName());
		student.setCourse(course);
		studentRepository.save(student);
		
	}

	@Override
	@Transactional
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
	@Transactional(readOnly = true)
	public StudentDTO getStudent(Long id) {
		Student student = studentRepository.getById(id);
		return student.toDTO();
	}
	
	@Override
	@Transactional(readOnly = true)
	public StudentDTO getStudentByName(String name) {
		Student student = studentRepository.getByName(name);
		return student.toDTO();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<GroupDTO> getGroupsByStudent(StudentDTO studentDTO) {
		Student student = studentRepository.getById(studentDTO.getId());
		Set<Group> groups = student.getGroups();
		List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();
		groups.forEach((x) -> {
			GroupDTO groupDTO = x.toDTO();
			groupDTOs.add(groupDTO);
		});
		return groupDTOs;
	}

	@Override
	@Transactional(readOnly = true)
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
	@Transactional
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void deleteStudents(List<Long> ids) {
		ids.forEach((x) -> {
			studentRepository.deleteById(x);
		});			
	}
	
	

}
