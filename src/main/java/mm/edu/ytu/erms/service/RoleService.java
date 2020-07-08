package mm.edu.ytu.erms.service;

import java.util.List;

import mm.edu.ytu.erms.model.Role;

public interface RoleService {
	
	Role create(Role role);
	
	Role update(Role role);
	
	List<Role> findAll();
	
	Role getOne(Integer id);
	
	void delete(Integer id);
}
