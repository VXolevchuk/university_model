package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Faculty;
import com.example.demo.dto.FacultyDTO;
import com.example.demo.repos.FacultyRepository;
import com.example.demo.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{
	private final FacultyRepository facultyRepository;

	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		super();
		this.facultyRepository = facultyRepository;
	}

	@Override
	@Transactional
	public void addFaculty(FacultyDTO facultyDTO) {
		if(facultyRepository.existsByName(facultyDTO.getName()))
			return;
		Faculty faculty = Faculty.fromDTO(facultyDTO);
		facultyRepository.save(faculty);	
	}

	@Override
	@Transactional
	public void addFaculties(List<FacultyDTO> facultyDTOs) {
		facultyDTOs.forEach((x) -> {
			if(facultyRepository.existsByName(x.getName())) {
				
			} else {
				Faculty faculty = Faculty.fromDTO(x);
				facultyRepository.save(faculty);
			}
			});
	}

	@Override
	@Transactional(readOnly = true)
	public FacultyDTO getFaculty(Long id) {
		Faculty faculty = facultyRepository.getById(id);
		return faculty.toDTO();
	}

	@Override
	@Transactional(readOnly = true)
	public List<FacultyDTO> getAllFaculties() {
		List<Faculty> faculties = facultyRepository.findAll();
		List<FacultyDTO> facultyDTOs = new ArrayList<FacultyDTO>();
		faculties.forEach((x) -> {
			FacultyDTO facultyDTO = x.toDTO();
			facultyDTOs.add(facultyDTO);
		});
		return facultyDTOs;
	}

	@Override
	@Transactional
	public void deleteFaculty(Long id) {
		facultyRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void deleteFaculties(List<Long> ids) {
		ids.forEach((x) -> {
			facultyRepository.deleteById(x);
		});
		
	}
	
	

}
