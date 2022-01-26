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

import com.example.demo.dto.FacultyDTO;
import com.example.demo.dto.result.BadRequestResult;
import com.example.demo.dto.result.ResultDTO;
import com.example.demo.dto.result.SuccessResult;
import com.example.demo.service.FacultyService;


@RestController
@RequestMapping("/faculties")
public class FacultyController {
	private final FacultyService facultyService;
	
	public FacultyController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}

	@GetMapping()
	public List<FacultyDTO> getGroups() {		
		return facultyService.getAllFaculties();
	}
	
	@PostMapping("add")
	public ResponseEntity<ResultDTO> addGroup(@RequestBody FacultyDTO facultyDTO) {
		facultyService.addFaculty(facultyDTO);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);	
	}
	
	@PostMapping("delete")
	public  ResponseEntity<ResultDTO> deleteGroup(@RequestParam(name = "id", required = false) Long id) {
		facultyService.deleteFaculty(id);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
	}
	

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResultDTO> handleException() {
		return new ResponseEntity<>(new BadRequestResult(), HttpStatus.BAD_REQUEST);
	}

}
