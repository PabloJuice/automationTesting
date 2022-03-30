package com.pablojuice.task_6.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "studentId", nullable = false)
	private long id;

	@Column(name = "studentName")
	private String name;

	@Column(name = "studentForm")
	private Integer form;

	@Column(name = "studentEnteringDate")
	private Date enteringDate;

	public Student(String name, Integer form, Date enteringDate) {
		this.name = name;
		this.form = form;
		this.enteringDate = enteringDate;
	}
}
