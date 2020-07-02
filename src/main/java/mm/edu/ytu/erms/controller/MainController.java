package mm.edu.ytu.erms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MainController {
	
	@GetMapping
	public Map<String, Object> appInfo() {
		Map<String, Object> app = new HashMap<String, Object>();
		app.put("name", "erms-be");
		app.put("version", "1.0.0");
		app.put("description", "Backend REST API project for Exam Result Management System using Spring Boot and Spring Data JPA with MySQL database");
		return app;
	}

}
