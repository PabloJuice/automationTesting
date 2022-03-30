package task_7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task_7.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}