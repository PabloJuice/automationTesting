package task_7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_7.entities.Teacher;
import task_7.repositories.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;

	public TeacherService(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	public Teacher addTeacher(Teacher teacher) {
		if (teacher != null && !teacherRepository.existsById(teacher.getId())) {
			return teacherRepository.save(teacher);
		}
		return null;
	}

	public Teacher getTeacher(Teacher teacher) {
		if (teacher != null && teacherRepository.existsById(teacher.getId())) {
			return teacherRepository.getById(teacher.getId());
		}
		return null;
	}

	public Teacher getTeacherById(Long teacherId) {
		if (teacherId != null && teacherRepository.existsById(teacherId)) {
			return teacherRepository.getById(teacherId);
		}
		return null;
	}

	public Teacher updateTeacher(Teacher teacher) {
		if (teacher != null && teacherRepository.existsById(teacher.getId())) {
			return teacherRepository.save(teacher);
		}
		return null;
	}

	public void deleteTeacher(Teacher teacher) {
		if (teacher != null && teacherRepository.existsById(teacher.getId())) {
			teacherRepository.delete(teacher);
		}
	}

	public void deleteTeacherById(Long teacherId) {
		if (teacherId != null && teacherRepository.existsById(teacherId)) {
			teacherRepository.deleteById(teacherId);
		}
	}

	public TeacherRepository getTeacherRepository() {
		return teacherRepository;
	}
}
