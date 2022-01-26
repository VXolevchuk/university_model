package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GroupDTO;
import com.example.demo.dto.StudentDTO;

public interface StudentService {
	public void addStudent(StudentDTO studentDTO);
	public void addStudents(List<StudentDTO> studentDTOs);
	public StudentDTO getStudent(Long id);
	public List<StudentDTO> getAllStudents();
	public void deleteStudent(Long id);
	public void deleteStudents(List<Long> ids);
	
	public StudentDTO getStudentByName(String name);
	public List<GroupDTO> getGroupsByStudent(StudentDTO studentDTO);
	

}
