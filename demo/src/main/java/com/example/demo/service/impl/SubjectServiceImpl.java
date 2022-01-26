package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Subject;
import com.example.demo.dto.SubjectDTO;
import com.example.demo.repos.SubjectRepository;
import com.example.demo.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	private final SubjectRepository subjectRepository;
	
	public SubjectServiceImpl(SubjectRepository subjectRepository) {
		super();
		this.subjectRepository = subjectRepository;
	}

	@Override
	@Transactional
	public void addSubject(SubjectDTO subjectDTO) {
		if(subjectRepository.existsByName(subjectDTO.getName()))
			return;
		Subject subject = Subject.fromDTO(subjectDTO);
		subjectRepository.save(subject);
		
	}

	@Override
	@Transactional
	public void addSubjects(List<SubjectDTO> subjectDTOs) {
		subjectDTOs.forEach((x) -> {
			if(subjectRepository.existsByName(x.getName())) {
				
			} else {
				Subject subject = Subject.fromDTO(x);
				subjectRepository.save(subject);
			}
			});
	}

	@Override
	@Transactional(readOnly = true)
	public SubjectDTO getSubject(Long id) {
		Subject subject = subjectRepository.getById(id);
		return subject.toDTO();
	}

	@Override
	@Transactional(readOnly = true)
	public List<SubjectDTO> getAllSubjects() {
		List<Subject> subjects = subjectRepository.findAll();
		List<SubjectDTO> subjectDTOs = new ArrayList<SubjectDTO>();
		subjects.forEach((x) -> {
			SubjectDTO subjectDTO = x.toDTO();
			subjectDTOs.add(subjectDTO);
		});
		return subjectDTOs;
	}

	@Override
	@Transactional
	public void deleteSubject(Long id) {
		subjectRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void deleteSubjects(List<Long> ids) {
		ids.forEach((x) -> {
			subjectRepository.deleteById(x);
		});
		
	}

}
