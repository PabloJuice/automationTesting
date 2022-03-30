package task_7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task_7.entities.SubjectMaterial;

public interface SubjectMaterialRepository extends JpaRepository<SubjectMaterial, Long> {
}