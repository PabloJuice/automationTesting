package task_7.entities;

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
@Table(name = "subjectMaterials")
public class SubjectMaterial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "subjectMaterialId", nullable = false)
	private long id;

	@Column(name = "subjectMaterialObject")
	private String material;

	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "subjectOwnerId", referencedColumnName = "subjectId")
	private Subject subject;

	public SubjectMaterial(String material, Subject subject) {
		this.material = material;
		this.subject = subject;
	}
}
