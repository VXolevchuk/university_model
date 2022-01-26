package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClassroomDTO;
import com.example.demo.dto.result.BadRequestResult;
import com.example.demo.dto.result.ResultDTO;
import com.example.demo.dto.result.SuccessResult;
import com.example.demo.service.ClassroomService;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {
	private final ClassroomService classroomService;

	public ClassroomController(ClassroomService classroomService) {
		super();
		this.classroomService = classroomService;
	}
	
	@GetMapping()
	public List<ClassroomDTO> getClassrooms() {		
		return classroomService.getAllClassrooms();
	}
	
	@PostMapping("add")
	public ResponseEntity<ResultDTO> addClassroom(@RequestBody ClassroomDTO classroomDTO) {
		classroomService.addClassroom(classroomDTO);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);	
	}
	
	@PostMapping("availability")
	public ResponseEntity<ResultDTO> setAvalability(@RequestBody ClassroomDTO classroomDTO) {
		classroomService.setAvailable(classroomDTO);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
	}
	
	@PostMapping("delete")
	public  ResponseEntity<ResultDTO> deleteClassroom(@RequestParam(name = "id", required = false) Long id) {
		classroomService.deleteClassroom(id);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
	}
	

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResultDTO> handleException() {
		return new ResponseEntity<>(new BadRequestResult(), HttpStatus.BAD_REQUEST);
	}

}
