package com.example.demo.dto;

import java.util.Date;

import com.example.demo.Model.LessonType;

public class LessonDTO {
	private Long id;
	
	private Date time;
	
	private Long classroomNumber;
	
	private LessonType type;
	
	private String subjectName;
	
	public LessonDTO() {
		super();
	}
	
	public LessonDTO(Long id, Date time, Long classroomNumber, LessonType type, String subjectName) {
		super();
		this.id = id;
		this.time = time;
		this.classroomNumber = classroomNumber;
		this.type = type;
		this.subjectName = subjectName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Long getClassroomNumber() {
		return classroomNumber;
	}

	public void setClassroomNumber(Long classroomNumber) {
		this.classroomNumber = classroomNumber;
	}

	public LessonType getType() {
		return type;
	}

	public void setType(LessonType type) {
		this.type = type;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}	
}
