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

import mm.edu.ytu.erms.model.AcademicYear;
import mm.edu.ytu.erms.service.AcademicYearService;

@RestController
@CrossOrigin
@RequestMapping("/academic_year")
public class AcademicYearController {
	@Autowired
	private AcademicYearService academicYearService;
	
	@GetMapping
	public List<AcademicYear> getAll() {
		return academicYearService.getAll();
	}
	
	@GetMapping("{id}")
	public AcademicYear getById(@PathVariable Integer id) {
		return academicYearService.getById(id);
	}
	
	@PostMapping
	public AcademicYear create(@RequestBody AcademicYear academicYear) {
		return academicYearService.create(academicYear);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public AcademicYear update(@RequestBody AcademicYear academicYear) {
		return academicYearService.update(academicYear);
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Integer id) {
		academicYearService.deleteById(id);
	}
}
