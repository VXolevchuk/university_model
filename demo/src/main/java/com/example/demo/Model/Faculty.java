package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.example.demo.dto.FacultyDTO;

@Entity
@Table(name = "Faculties")
public class Faculty {
	@Id
    @GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="faculty", cascade=CascadeType.ALL)
	private List<Course> courses = new ArrayList<Course>();

	public Faculty() {
		super();
	}

	public Faculty(String name) {
		super();
		this.name = name;
	}
	
	public static Faculty fromDTO(FacultyDTO facultyDTO) {
		return new Faculty(facultyDTO.getName());
	}
	
	public FacultyDTO toDTO() {
		return new FacultyDTO(this.id, this.name);
	}
	
	public void addCourse(Course course) {
		course.setFaculty(this); 
		this.courses.add(course);
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courses, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + "]";
	}
	
	

}
