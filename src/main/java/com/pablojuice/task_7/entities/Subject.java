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
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "subjectId", nullable = false)
	private long id;

	@Column(name = "subjectTitle")
	private String title;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "courseTeacherId", referencedColumnName = "teacherId")
	private Teacher teacher;

	@OneToOne(mappedBy = "subject", orphanRemoval = true, cascade = CascadeType.ALL)
	private SubjectMaterial material;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "studentSubjects",
			joinColumns = @JoinColumn(name = "studentSubjectId", referencedColumnName = "subjectId"),
			inverseJoinColumns = @JoinColumn(name = "subjectStudentId", referencedColumnName = "studentId")
	)
	private List<Student> students = new ArrayList<>();

	public Subject(String title) {
		this.title = title;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
}
