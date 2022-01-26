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

import com.example.demo.dto.SubjectDTO;
import com.example.demo.dto.result.BadRequestResult;
import com.example.demo.dto.result.ResultDTO;
import com.example.demo.dto.result.SuccessResult;
import com.example.demo.service.SubjectService;


@RestController
@RequestMapping("/subjects")
public class SubjectController {
	private final SubjectService subjectService;
	
	public SubjectController(SubjectService subjectService) {
		super();
		this.subjectService = subjectService;
	}

	@GetMapping()
	public List<SubjectDTO> getSubjects() {		
		return subjectService.getAllSubjects();
	}
	
	@PostMapping("add")
	public ResponseEntity<ResultDTO> addSubject(@RequestBody SubjectDTO subjectDTO) {
		subjectService.addSubject(subjectDTO);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);	
	}
	
	@PostMapping("delete")
	public  ResponseEntity<ResultDTO> deleteSubject(@RequestParam(name = "id", required = false) Long id) {
		subjectService.deleteSubject(id);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
	}
	

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResultDTO> handleException() {
		return new ResponseEntity<>(new BadRequestResult(), HttpStatus.BAD_REQUEST);
	}

}
