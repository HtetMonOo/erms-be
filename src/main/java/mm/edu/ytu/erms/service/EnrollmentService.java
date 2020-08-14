package mm.edu.ytu.erms.service;

import java.util.List;

import mm.edu.ytu.erms.model.Enrollment;

public interface EnrollmentService {
	List<Enrollment> getAll();
	Enrollment getById(Long id);
	Enrollment create(Enrollment enrollment);
	Enrollment update(Enrollment enrollment);
	void deleteById(Long id);
}