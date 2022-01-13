package com.example.demo.dto;

public class FacultyDTO {
	private Long id;
	
	private String name;

	public FacultyDTO() {
		super();
	}

	public FacultyDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
