package mm.edu.ytu.erms.service;

import java.util.List;

import mm.edu.ytu.erms.model.Classes;

public interface ClassesService {
	List<Classes> getAll();
	Classes getById(Integer id);
	Classes create(Classes classes);
	Classes update(Classes classes);
	void deleteById(Integer id);
}