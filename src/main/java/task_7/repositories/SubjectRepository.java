package task_7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task_7.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}