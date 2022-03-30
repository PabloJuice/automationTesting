package com.pablojuice.task_6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pablojuice.task_6.entities.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
