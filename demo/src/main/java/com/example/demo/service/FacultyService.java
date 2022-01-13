package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FacultyDTO;

public interface FacultyService {
	public void addFaculty(FacultyDTO facultyDTO);
	public void addFaculties(List<FacultyDTO> facultyDTOs);
	public FacultyDTO getFaculty(Long id);
	public List<FacultyDTO> getAllFaculties();
	public void deleteFaculty(Long id);
	public void deleteFaculties(List<Long> ids);

}
