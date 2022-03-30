package com.pablojuice.task_6.services;

import com.pablojuice.task_6.entities.Student;
import com.pablojuice.task_6.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student addStudent(Student student) {
		if (student != null && !studentRepository.existsById(student.getId())) {
			return studentRepository.save(student);
		}
		return null;
	}

	public Student getStudent(Student student) {
		if (student != null && studentRepository.existsById(student.getId())) {
			return studentRepository.getById(student.getId());
		}
		return null;
	}

	public Student getStudentById(Long studentId) {
		if (studentId != null && studentRepository.existsById(studentId)) {
			return studentRepository.getById(studentId);
		}
		return null;
	}

	public Student updateStudent(Student student) {
		if (student != null && studentRepository.existsById(student.getId())) {
			return studentRepository.save(student);
		}
		return null;
	}

	public void deleteStudent(Student student) {
		if (student != null && studentRepository.existsById(student.getId())) {
			studentRepository.delete(student);
		}
	}

	public void deleteStudentById(Long studentId) {
		if (studentId != null && studentRepository.existsById(studentId)) {
			studentRepository.deleteById(studentId);
		}
	}

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}
}
