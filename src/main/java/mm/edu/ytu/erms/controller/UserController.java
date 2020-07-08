package mm.edu.ytu.erms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.edu.ytu.erms.model.User;
import mm.edu.ytu.erms.payload.request.LoginRequest;
import mm.edu.ytu.erms.payload.request.RegistrationRequest;
import mm.edu.ytu.erms.payload.response.MessageResponse;
import mm.edu.ytu.erms.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("{username}")
	@PreAuthorize("hasRole('ADMIN')")
	public User findByUsername(@PathVariable String username) {
		return userService.findByUsername(username);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(userService.authenticateUser(loginRequest));
		
	}
	
	@PostMapping("/register")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
		return userService.registerUser(registrationRequest);
	}
	
	@RequestMapping(path = "{username}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable String username) {
		userService.delete(username);
		return ResponseEntity.ok(new MessageResponse("Successfully deleted"));
	}
	
	@RequestMapping(path = "{username}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable String username, @RequestBody RegistrationRequest user, HttpServletRequest request) {
		return userService.update(username, user, request);
	}
	
}
