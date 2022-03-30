package task_6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task_6.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
