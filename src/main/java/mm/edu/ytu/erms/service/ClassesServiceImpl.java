package mm.edu.ytu.erms.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.Classes;
import mm.edu.ytu.erms.repository.ClassesRepository;

@Service
public class ClassesServiceImpl implements ClassesService {
	@Autowired
	private ClassesRepository classesRepository;

	@Override
	public List<Classes> getAll() {
		return classesRepository.findAll();
	}

	@Override
	public Classes getById(Integer id) {
		return classesRepository.getOne(id);
	}

	@Override
	public Classes create(Classes classes) {
		return classesRepository.saveAndFlush(classes);
	}

	@Override
	public Classes update(Classes classes) {
		Classes oldClass = classesRepository.getOne(classes.getId());
		BeanUtils.copyProperties(classes, oldClass, "id");
		return classesRepository.saveAndFlush(oldClass);
	}

	@Override
	public void deleteById(Integer id) {
		classesRepository.deleteById(id);
	}
}
