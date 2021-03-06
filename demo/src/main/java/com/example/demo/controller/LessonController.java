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

import com.example.demo.dto.LessonDTO;
import com.example.demo.dto.result.BadRequestResult;
import com.example.demo.dto.result.ResultDTO;
import com.example.demo.dto.result.SuccessResult;
import com.example.demo.service.LessonService;

@RestController
@RequestMapping("/lessons")
public class LessonController {
	private final LessonService lessonService;
	
	public LessonController(LessonService lessonService) {
		super();
		this.lessonService = lessonService;
	}

	@GetMapping()
	public List<LessonDTO> getLessons() {		
		return lessonService.getAllLessons();
	}
	
	@PostMapping("add")
	public ResponseEntity<ResultDTO> addLesson(@RequestBody LessonDTO lessonDTO) {
		lessonService.addLesson(lessonDTO);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);	
	}
	
	@PostMapping("delete")
	public  ResponseEntity<ResultDTO> deleteLesson(@RequestParam(name = "id", required = false) Long id) {
		lessonService.deleteLesson(id);
		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
	}
	
	

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResultDTO> handleException() {
		return new ResponseEntity<>(new BadRequestResult(), HttpStatus.BAD_REQUEST);
	}

}
