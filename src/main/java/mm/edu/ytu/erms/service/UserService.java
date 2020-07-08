package mm.edu.ytu.erms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import mm.edu.ytu.erms.model.User;
import mm.edu.ytu.erms.payload.request.LoginRequest;
import mm.edu.ytu.erms.payload.request.RegistrationRequest;
import mm.edu.ytu.erms.payload.response.JwtResponse;

public interface UserService {
	
	JwtResponse authenticateUser(LoginRequest loginRequest);
	
	ResponseEntity<?> registerUser(RegistrationRequest registrationRequest);
	
	void delete(String username);
	
	List<User> getAllUser();
	
	User findByUsername(String username);
	
	ResponseEntity<?> update(String username, RegistrationRequest user, HttpServletRequest request);

}
