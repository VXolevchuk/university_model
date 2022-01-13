package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClassroomDTO;

public interface ClassroomService {
	public void addClassroom(ClassroomDTO classroomDTO);
	public void addClassrooms(List<ClassroomDTO> classroomDTOs);
	public void setAvailable(ClassroomDTO classroom);
	public ClassroomDTO getClassroom(Long id);
	public List<ClassroomDTO> getAllClassrooms();
	public void deleteClassroom(Long id);
	public void deleteClassrooms(List<Long> ids);
	
}
