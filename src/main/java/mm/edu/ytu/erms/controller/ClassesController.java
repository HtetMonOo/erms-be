package mm.edu.ytu.erms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.edu.ytu.erms.model.Classes;
import mm.edu.ytu.erms.service.ClassesService;

@RestController
@CrossOrigin
@RequestMapping("/classes")
public class ClassesController {
	@Autowired
	private ClassesService classesService;
	
	@GetMapping
	public List<Classes> getAll() {
		return classesService.getAll();
	}
	
	@GetMapping("{id}")
	public Classes getById(@PathVariable Integer id) {
		return classesService.getById(id);
	}
	
	@PostMapping
	public Classes create(@RequestBody Classes classes) {
		return classesService.create(classes);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Classes update(@RequestBody Classes classes) {
		return classesService.update(classes);
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Integer id) {
		classesService.deleteById(id);
	}
}
