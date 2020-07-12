package mm.edu.ytu.erms.service;

import java.util.List;
import org.springframework.stereotype.Service;
import mm.edu.ytu.erms.model.Student;

@Service
public interface StudentService {
	List<Student> getAll(Integer pageNo, Integer pageSize);
	Student getOne(String entrance_id);
	Student save(Student student);
	Student update(Student student);
	void deleteById(String entrance_id);
	
}
