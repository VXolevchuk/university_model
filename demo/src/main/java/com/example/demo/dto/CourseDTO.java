package com.example.demo.dto;

import com.example.demo.Model.AcademicYear;

public class CourseDTO {
	private Long id;
	
	private String name;
	
	private AcademicYear year;
	
	public CourseDTO() {
		super();
	}

	public CourseDTO(Long id, String name, AcademicYear year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
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

	public AcademicYear getYear() {
		return year;
	}

	public void setYear(AcademicYear year) {
		this.year = year;
	}
}
