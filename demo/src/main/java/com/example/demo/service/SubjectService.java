package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SubjectDTO;

public interface SubjectService {
	public void addSubject(SubjectDTO subjectDTO);
	public void addSubjects(List<SubjectDTO> subjectDTOs);
	public SubjectDTO getSubject(Long id);
	public List<SubjectDTO> getAllSubjects();
	public void deleteSubject(Long id);
	public void deleteSubjects(List<Long> ids);
	

}
