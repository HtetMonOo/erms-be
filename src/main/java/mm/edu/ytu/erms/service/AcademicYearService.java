package mm.edu.ytu.erms.service;

import java.util.List;

import mm.edu.ytu.erms.model.AcademicYear;

public interface AcademicYearService {
	List<AcademicYear> getAll();
	AcademicYear getById(Integer id);
	AcademicYear create(AcademicYear academicYear);
	AcademicYear update(AcademicYear academicYear);
	void deleteById(Integer id);
}
