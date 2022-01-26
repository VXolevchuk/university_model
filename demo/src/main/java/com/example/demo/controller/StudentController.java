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

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.result.BadRequestResult;
import com.example.demo.dto.result.ResultDTO;
import com.example.demo.dto.result.SuccessResult;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping()
	public List<StudentDTO> getStudents() {		
		return studentService.getAllStudents();
	}
	
	@PostMapping("add")
	public ResponseEntity<ResultDTO> addStudent(@RequestBody StudentDTO studentDTO) {
		studentService.addStudent(studentDTO);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);	
	}
		
	@PostMapping("delete")
	public  ResponseEntity<ResultDTO> deleteStudent(@RequestParam(name = "id", required = false) Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
	}
	

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResultDTO> handleException() {
		return new ResponseEntity<>(new BadRequestResult(), HttpStatus.BAD_REQUEST);
	}

}
