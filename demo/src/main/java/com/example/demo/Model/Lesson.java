package com.example.demo.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.dto.LessonDTO;

@Entity
@Table(name = "Lessons")
public class Lesson {
	@Id
    @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	
	@ManyToOne
	@JoinColumn(name="classroom_id")
	private Classroom classroom;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	@Enumerated(EnumType.STRING)
	private LessonType type;
	
	@ManyToMany(mappedBy = "lessons", fetch = FetchType.LAZY)
	private Set<Group> groups = new HashSet<Group>();

	public Lesson() {
		super();
	}

	public Lesson(Date time, LessonType type) {
		super();
		this.time = time;
		this.type = type;
	}
	
	public static Lesson fromDTO(LessonDTO lessonDTO) {
		return new Lesson(lessonDTO.getTime(), lessonDTO.getType());
	}
	
	public LessonDTO toDTO() {
		return new LessonDTO(this.id, this.time, this.classroom.getNumber(), this.type, this.subject.getName());
	}
	
	public void addGroup(Group group) {
		group.addLesson(this);
		this.groups.add(group);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public LessonType getType() {
		return type;
	}

	public void setType(LessonType type) {
		this.type = type;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classroom, groups, id, subject, time, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(classroom, other.classroom) && Objects.equals(groups, other.groups) && id == other.id
				&& Objects.equals(subject, other.subject) && Objects.equals(time, other.time) && type == other.type;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", time=" + time + ", classroom=" + classroom + ", subject=" + subject + ", type="
				+ type + "]";
	}
	
	
	
	

}
