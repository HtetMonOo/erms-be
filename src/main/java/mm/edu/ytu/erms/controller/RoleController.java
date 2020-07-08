package mm.edu.ytu.erms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.edu.ytu.erms.model.Role;
import mm.edu.ytu.erms.service.RoleService;

@CrossOrigin
@RestController
@RequestMapping("/role")
@PreAuthorize("hasRole('ADMIN')")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public List<Role> getAll() {
		return roleService.findAll();
	}
	
	@GetMapping("{id}")
	public Role getRoleById(@PathVariable Integer id) {
		return roleService.getOne(id);
	}
	
	@PostMapping
	public Role create(@RequestBody Role role) {
		return roleService.create(role);
	}
	
	@PutMapping
	public Role update(@RequestBody Role role) {
		return roleService.update(role);
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		roleService.delete(id);
	}

}
