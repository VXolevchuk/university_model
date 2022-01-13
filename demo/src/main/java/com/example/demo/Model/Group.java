package com.example.demo.Model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.dto.GroupDTO;

@Entity
@Table(name = "Groups")
public class Group {
	@Id
    @GeneratedValue
	private Long id;
	
	private Integer number;
	
	@ManyToMany(mappedBy = "groups")
	private Set<Student> students = new HashSet<Student>();
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "group_lesson",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
	private Set<Lesson> lessons = new HashSet<Lesson>();

	public Group() {
		super();
	}

	public Group(Integer number) {
		super();
		this.number = number;
	}
	
	public static Group fromDTO(GroupDTO groupDTO) {
		return new Group(groupDTO.getNumber());
	}
	
	public GroupDTO toDTO() {
		return new GroupDTO(this.id, this.number);
	}
	
	public void addStudent(Student student) {
		student.addGroup(this);
		this.students.add(student);
	}
	
	public void addLesson(Lesson lesson) {
		lesson.addGroup(this);
		this.lessons.add(lesson);
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lessons, number, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(id, other.id) && Objects.equals(lessons, other.lessons)
				&& Objects.equals(number, other.number) && Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", number=" + number + "]";
	}
	
	

}
