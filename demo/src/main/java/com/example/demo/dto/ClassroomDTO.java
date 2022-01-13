package com.example.demo.dto;

import com.example.demo.Model.ClassroomType;

public class ClassroomDTO {
	private Long id;
	
	private Long number;	
	
	private ClassroomType type;
	
	private Boolean available;

	public ClassroomDTO() {
		super();
	}

	public ClassroomDTO(Long id, Long number, ClassroomType type, Boolean available) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public ClassroomType getType() {
		return type;
	}

	public void setType(ClassroomType type) {
		this.type = type;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}
