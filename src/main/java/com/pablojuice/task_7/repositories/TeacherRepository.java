package com.pablojuice.task_7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pablojuice.task_7.entities.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}