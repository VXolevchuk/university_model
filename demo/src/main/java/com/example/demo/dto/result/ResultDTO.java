package com.example.demo.dto.result;

public abstract class ResultDTO {
	protected String description = "OK";

	public ResultDTO() {
		super();
	}

	public ResultDTO(String description) {
		super();
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
