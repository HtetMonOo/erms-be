package mm.edu.ytu.erms.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.Enrollment;
import mm.edu.ytu.erms.repository.EnrollmentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public List<Enrollment> getAll() {
		return enrollmentRepository.findAll();
	}

	@Override
	public Enrollment getById(Long id) {
		return enrollmentRepository.getOne(id);
	}

	@Override
	public Enrollment create(Enrollment enrollment) {
		return enrollmentRepository.saveAndFlush(enrollment);
	}

	@Override
	public Enrollment update(Enrollment enrollment) {
		Enrollment oldEnrollment = enrollmentRepository.getOne(enrollment.getId());
		BeanUtils.copyProperties(enrollment, oldEnrollment, "id");
		return enrollmentRepository.saveAndFlush(oldEnrollment);
	}

	@Override
	public void deleteById(Long id) {
		enrollmentRepository.deleteById(id);
	}
}