package com.example.demo.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.dto.SubjectDTO;

@Entity
@Table(name = "Subjects")
public class Subject {
	@Id
    @GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "subject_course",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses = new HashSet<Course>();
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Lesson> lessons = new ArrayList<Lesson>();

	public Subject() {
		super();
	}

	public Subject(String name) {
		super();
		this.name = name;
	}
	
	public static Subject fromDTO(SubjectDTO subjectDTO) {
		return new Subject(subjectDTO.getName());
	}
	
	public SubjectDTO toDTO() {
		return new SubjectDTO(this.id, this.name);
	}
	
	public void addCourse(Course course) {
		course.addSubject(this);
		this.courses.add(course);
	}
	
	public void addLesson(Lesson lesson) {
		lesson.setSubject(this);
		this.lessons.add(lesson);
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courses, id, lessons, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(id, other.id)
				&& Objects.equals(lessons, other.lessons) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}
	
	

}
