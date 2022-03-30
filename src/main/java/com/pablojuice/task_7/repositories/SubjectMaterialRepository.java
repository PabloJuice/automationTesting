package com.pablojuice.task_7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pablojuice.task_7.entities.SubjectMaterial;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMaterialRepository extends JpaRepository<SubjectMaterial, Long> {
}