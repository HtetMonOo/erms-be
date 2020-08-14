package mm.edu.ytu.erms.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.AcademicYear;
import mm.edu.ytu.erms.repository.AcademicYearRepository;

@Service
public class AcademicYearServiceImpl implements AcademicYearService {
	@Autowired
	private AcademicYearRepository academicYearRepository;

	@Override
	public List<AcademicYear> getAll() {
		return academicYearRepository.findAll();
	}

	@Override
	public AcademicYear getById(Integer id) {
		return academicYearRepository.getOne(id);
	}

	@Override
	public AcademicYear create(AcademicYear academicYear) {
		return academicYearRepository.saveAndFlush(academicYear);
	}

	@Override
	public AcademicYear update(AcademicYear academicYear) {
		AcademicYear oldAcademicYear = academicYearRepository.getOne(academicYear.getId());
		BeanUtils.copyProperties(academicYear, oldAcademicYear, "id");
		return academicYearRepository.saveAndFlush(oldAcademicYear);
	}

	@Override
	public void deleteById(Integer id) {
		academicYearRepository.deleteById(id);
	}
}