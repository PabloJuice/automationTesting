package com.pablojuice.task_7.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "teacherId", nullable = false)
	private long id;

	@Column(name = "teacherFirstName")
	private String firstName;

	@Column(name = "teacherLastName")
	private String lastName;

	@OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@Column(name = "teacherSubjects")
	private List<Subject> subjects = new ArrayList<>();

	public Teacher(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}
}
