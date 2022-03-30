package com.pablojuice.task_models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
	private String name;
	private String mail;
	private Integer salary;
}
