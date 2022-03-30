package task_7.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_7.entities.Subject;
import task_7.repositories.SubjectMaterialRepository;
import task_7.repositories.SubjectRepository;

@Getter
@Service
public class SubjectService {
	@Autowired
	private final SubjectRepository subjectRepository;
	@Autowired
	private final SubjectMaterialRepository subjectMaterialRepository;

	public SubjectService(SubjectRepository subjectRepository, SubjectMaterialRepository subjectMaterialRepository) {
		this.subjectRepository = subjectRepository;
		this.subjectMaterialRepository = subjectMaterialRepository;
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
}
