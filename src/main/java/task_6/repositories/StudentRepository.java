package task_6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task_6.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
