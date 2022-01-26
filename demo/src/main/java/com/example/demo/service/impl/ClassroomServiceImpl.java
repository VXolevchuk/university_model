package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Classroom;
import com.example.demo.dto.ClassroomDTO;
import com.example.demo.repos.ClassroomRepository;
import com.example.demo.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService{
	private final ClassroomRepository classroomRepository;
	
	public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
		super();
		this.classroomRepository = classroomRepository;
	}

	@Override
	@Transactional
	public void addClassroom(ClassroomDTO classroomDTO) {
		if(classroomRepository.existsByNumber(classroomDTO.getNumber()))
			return;
		Classroom classroom = Classroom.fromDTO(classroomDTO);
		classroomRepository.save(classroom);	
	}

	@Override
	@Transactional
	public void addClassrooms(List<ClassroomDTO> classroomDTOs) {
		classroomDTOs.forEach((x) -> {
		    if(classroomRepository.existsByNumber(x.getNumber())) {
			
		    } else {
			    Classroom classroom = Classroom.fromDTO(x);
			    classroomRepository.save(classroom);
		    }
		});
	}

	@Override
	@Transactional
	public void setAvailable(ClassroomDTO classroomDTO) {
		Classroom classroom = classroomRepository.getById(classroomDTO.getId());
		classroom.setAvailable(classroomDTO.getAvailable());
		classroomRepository.save(classroom);	
	}

	@Override
	@Transactional(readOnly = true)
	public ClassroomDTO getClassroom(Long id) {
		Classroom classroom = classroomRepository.getById(id);
		return classroom.toDTO();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClassroomDTO> getAllClassrooms() {
		List<Classroom> classrooms = classroomRepository.findAll();
		List<ClassroomDTO> classroomDTOs = new ArrayList<ClassroomDTO>();
		classrooms.forEach((x) -> {
			ClassroomDTO classroomDTO = x.toDTO();
			classroomDTOs.add(classroomDTO);
		});
		return classroomDTOs;
	}

	@Override
	@Transactional
	public void deleteClassroom(Long id) {
		classroomRepository.deleteById(id);	
	}

	@Override
	@Transactional
	public void deleteClassrooms(List<Long> ids) {
		ids.forEach((x) -> {
			classroomRepository.deleteById(x);
		});
	}
	

}
