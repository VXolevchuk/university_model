package com.example.demo.Model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.dto.StudentDTO;

@Entity
@Table(name = "Students")
public class Student {
	@Id
    @GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "student_group",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
	private Set<Group> groups = new HashSet<Group>();
	
	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	
	public static Student fromDTO(StudentDTO studentDTO) {
		return new Student(studentDTO.getName());
	}
	
	public StudentDTO toDTO() {
		return new StudentDTO(this.id, this.name, this.course.getName(), this.course.getYear());
	}
	
	public void addGroup(Group group) {
		group.addStudent(this);
		this.groups.add(group);
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, groups, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(course, other.course) && Objects.equals(groups, other.groups)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + "]";
	}

	
	

	

	
	
	
	
	
	
	

}
