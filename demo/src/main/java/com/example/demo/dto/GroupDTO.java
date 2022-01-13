package com.example.demo.dto;

public class GroupDTO {
	private Long id;
	
	private Integer number;

	public GroupDTO() {
		super();
	}

	public GroupDTO(Long id, Integer number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
