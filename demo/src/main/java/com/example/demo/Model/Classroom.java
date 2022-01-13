package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.example.demo.dto.ClassroomDTO;

@Entity
@Table(name = "Classrooms")
public class Classroom {
	@Id
    @GeneratedValue
	private Long id;
	
	private Long number;	
	
	@Enumerated(EnumType.STRING)
	private ClassroomType type;
	
	private Boolean available;
	
	@OneToMany(mappedBy="classroom", cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Lesson> lessons = new ArrayList<Lesson>();
	
	public Classroom() {
		super();
	}
	
	public Classroom(Long number, ClassroomType type, Boolean available) {
		super();
		this.number = number;
		this.type = type;
		this.available = available;
	}
	
	public static Classroom fromDTO(ClassroomDTO classroomDTO) {
		return new Classroom(classroomDTO.getNumber(), classroomDTO.getType(), classroomDTO.getAvailable());
	}
	
	public ClassroomDTO toDTO() {
		return new ClassroomDTO(this.id, this.number, this.type, this.available);
	}

	public void addLesson(Lesson lesson) {
		lesson.setClassroom(this);
		this.lessons.add(lesson);
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

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public int hashCode() {
		return Objects.hash(available, id, lessons, number, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classroom other = (Classroom) obj;
		return Objects.equals(available, other.available) && Objects.equals(id, other.id)
				&& Objects.equals(lessons, other.lessons) && Objects.equals(number, other.number) && type == other.type;
	}

	@Override
	public String toString() {
		return "Classroom [id=" + id + ", number=" + number + ", type=" + type + ", available=" + available + "]";
	}
	
}
