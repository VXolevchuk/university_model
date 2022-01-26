package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GroupDTO;
import com.example.demo.dto.LessonDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.result.BadRequestResult;
import com.example.demo.dto.result.ResultDTO;
import com.example.demo.service.LessonService;
import com.example.demo.service.StudentService;


@RestController
public class MainPageController {
	private final LessonService lessonService;
	private final StudentService studentService;

	public MainPageController(LessonService lessonService, StudentService studentService) {
		super();
		this.lessonService = lessonService;
		this.studentService = studentService;
	}

	@GetMapping("/student")
	public StudentDTO getStudent(@RequestParam(name = "name") String name) {
		return studentService.getStudentByName(name);
	}
	
	@GetMapping("groups")
	public List<GroupDTO> getStudentGroups(@RequestBody StudentDTO studentDTO) {
		return studentService.getGroupsByStudent(studentDTO);
	}
	
	@GetMapping("shedule")
	public List<LessonDTO> getTodayShedule(@RequestParam(name = "groupId", required = false) Long groupId) {
		return lessonService.getTodayLessons(new Date(), groupId);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResultDTO> handleException() {
		return new ResponseEntity<>(new BadRequestResult(), HttpStatus.BAD_REQUEST);
	}

}
