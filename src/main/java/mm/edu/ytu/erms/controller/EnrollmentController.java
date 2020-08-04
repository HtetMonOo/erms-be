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

import mm.edu.ytu.erms.model.Enrollment;
import mm.edu.ytu.erms.service.EnrollmentService;

@RestController
@CrossOrigin
@RequestMapping("/enrollment")
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollmentService;
	
	@GetMapping
	public List<Enrollment> getAll() {
		return enrollmentService.getAll();
	}
	
	@GetMapping(path = "{id}")
	public Enrollment getById(@PathVariable Long id) {
		return enrollmentService.getById(id);
	}
	
	@PostMapping
	public Enrollment create(@RequestBody Enrollment enrollment) {
		return enrollmentService.create(enrollment);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Enrollment update(@RequestBody Enrollment enrollment) {
		return enrollmentService.update(enrollment);
	}
	
	@RequestMapping(path = "{id}")
	public void deleteById(@PathVariable Long id) {
		enrollmentService.deleteById(id);
	}
}