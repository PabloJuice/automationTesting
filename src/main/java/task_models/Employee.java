package task_models;

import lombok.*;

import java.util.Objects;

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
