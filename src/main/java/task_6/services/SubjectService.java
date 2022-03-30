package task_6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_6.entities.Subject;
import task_6.repositories.SubjectRepository;

@Service
public class SubjectService {
	@Autowired
	private final SubjectRepository subjectRepository;

	public SubjectService(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

	public Subject addSubject(Subject subject) {
		if (subject != null && !subjectRepository.existsById(subject.getId())) {
			return subjectRepository.save(subject);
		}
		return null;
	}

	public Subject getSubject(Subject subject) {
		if (subject != null && subjectRepository.existsById(subject.getId())) {
			return subjectRepository.getById(subject.getId());
		}
		return null;
	}

	public Subject getSubjectById(Long subjectId) {
		if (subjectId != null && subjectRepository.existsById(subjectId)) {
			return subjectRepository.getById(subjectId);
		}
		return null;
	}

	public Subject updateSubject(Subject subject) {
		if (subject != null && subjectRepository.existsById(subject.getId())) {
			return subjectRepository.save(subject);
		}
		return null;
	}

	public void deleteSubject(Subject subject) {
		if (subject != null && subjectRepository.existsById(subject.getId())) {
			subjectRepository.delete(subject);
		}
	}

	public void deleteSubjectById(Long subjectId) {
		if (subjectId != null && subjectRepository.existsById(subjectId)) {
			subjectRepository.deleteById(subjectId);
		}
	}

	public SubjectRepository getSubjectRepository() {
		return subjectRepository;
	}
}
