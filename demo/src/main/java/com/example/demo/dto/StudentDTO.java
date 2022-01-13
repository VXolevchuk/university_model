package com.example.demo.dto;

import com.example.demo.Model.AcademicYear;

public class StudentDTO {
	private Long id;
	
	private String name;
	
	private String courseName;
	
	private AcademicYear academicYear;
	
	public StudentDTO() {
		super();
	}

	public StudentDTO(Long id, String name, String courseName, AcademicYear academicYear) {
		super();
		this.id = id;
		this.name = name;
		this.academicYear = academicYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}
}
