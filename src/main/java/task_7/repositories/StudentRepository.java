package task_7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task_7.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}