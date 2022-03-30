package com.pablojuice.task_6.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

	@Column(name = "subjectName")
	private String name;

	public Subject(String name) {
		this.name = name;
	}
}
