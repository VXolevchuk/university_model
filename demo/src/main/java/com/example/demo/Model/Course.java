package com.example.demo.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.dto.CourseDTO;

@Entity
@Table(name = "Courses")
public class Course {
	@Id
    @GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	@Enumerated(EnumType.STRING)
	private AcademicYear year;
	
	@OneToMany(mappedBy="course", cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Student> students = new ArrayList<Student>();
	
	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
	private Set<Subject> subjects = new HashSet<Subject>();

	public Course() {
		super();
	}

	public Course(String name, AcademicYear year) {
		super();
		this.name = name;
		this.year = year;
	}
	
	public static Course fromDTO(CourseDTO courseDTO) {
		return new Course(courseDTO.getName(), courseDTO.getYear());
	}
	
	public CourseDTO toDTO() {
		return new CourseDTO(this.id, this.name, this.year);
	}
	
	public void addStudent(Student student) {
		student.setCourse(this);
		this.students.add(student);
	}
	
	public void addSubject(Subject subject) {
		subject.addCourse(this);
		this.subjects.add(subject);
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public AcademicYear getYear() {
		return year;
	}

	public void setYear(AcademicYear year) {
		this.year = year;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public int hashCode() {
		return Objects.hash(faculty, id, name, students, subjects, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(faculty, other.faculty) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(students, other.students)
				&& Objects.equals(subjects, other.subjects) && year == other.year;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", faculty=" + faculty + ", year=" + year + "]";
	}
	
	
	

}
