package mm.edu.ytu.erms.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.Student;
import mm.edu.ytu.erms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired 
	StudentRepository studentRepository;
	
	@Transactional
	@Override
	public List<Student> getAll(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Student> pagedResult = studentRepository.findAll(paging);
		if(pagedResult.hasContent()){
			return pagedResult.getContent();
		}else{
			return new ArrayList<Student>();
		}
	}
	
	@Transactional
	@Override
	public Student getOne(String entrance_id) {
		return studentRepository.getOne(entrance_id);
	}
	
	
	@Transactional
	@Override
	public Student save(Student student) {
		return studentRepository.saveAndFlush(student);
	}

	@Transactional
	@Override
	public Student update(Student student) {
		Student oldStudent = studentRepository.getOne(student.getEntrance_id());
		BeanUtils.copyProperties(oldStudent, student);
		return studentRepository.saveAndFlush(oldStudent);
	}
	
	@Transactional
	@Override
	public void deleteById(String entrance_id) {
		studentRepository.deleteById(entrance_id);
	}
	
	
}
